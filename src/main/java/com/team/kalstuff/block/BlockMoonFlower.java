package com.team.kalstuff.block;

import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.team.kalstuff.StartupCommon;
import com.team.kalstuff.tileentity.TileEntityMoonFlower;

public class BlockMoonFlower extends BlockBush implements ITileEntityProvider {
	
	
    public static final PropertyInteger NIGHT = PropertyInteger.create("night", 0, 1);
	public BlockMoonFlower(float light) {
        this.setDefaultState(this.blockState.getBaseState().withProperty(NIGHT, Integer.valueOf(0)));
        this.setLightLevel((light) / 16.0f);
        this.setStepSound(soundTypeGrass);
	}

    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        super.breakBlock(worldIn, pos, state);
        worldIn.removeTileEntity(pos);
    }

    /**
     * Called on both Client and Server when World#addBlockEvent is called
     */
    public boolean onBlockEventReceived(World worldIn, BlockPos pos, IBlockState state, int eventID, int eventParam) {
        super.onBlockEventReceived(worldIn, pos, state, eventID, eventParam);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
    }
    
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityMoonFlower();
	}
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);
		if (worldIn.getWorldTime() >= 13000 && ((Integer)state.getValue(NIGHT)).intValue() != 1)
			worldIn.setBlockState(pos, state.withProperty(NIGHT, Integer.valueOf(1)));
		else if (worldIn.getWorldTime() > 1000 && worldIn.getWorldTime() < 13000) worldIn.setBlockState(pos, state.withProperty(NIGHT, Integer.valueOf(0)));

	}

	public void checkSky(World worldIn, BlockPos pos) {
		IBlockState iblockstate = worldIn.getBlockState(pos);
		if (worldIn.getBlockState(pos).getBlock().getClass() == BlockMoonFlower.class) {
			if (worldIn.canSeeSky(pos) && ((Integer)worldIn.getBlockState(pos).getValue(NIGHT)).intValue() == 1) {
				if (worldIn.getCurrentMoonPhaseFactor() == 0) worldIn.setBlockState(pos, StartupCommon.blockMoonFlower1.getDefaultState().withProperty(NIGHT, iblockstate.getValue(NIGHT)));
				if (worldIn.getCurrentMoonPhaseFactor() == .25) worldIn.setBlockState(pos, StartupCommon.blockMoonFlower2.getDefaultState().withProperty(NIGHT, iblockstate.getValue(NIGHT)));
				if (worldIn.getCurrentMoonPhaseFactor() == .50) worldIn.setBlockState(pos, StartupCommon.blockMoonFlower3.getDefaultState().withProperty(NIGHT, iblockstate.getValue(NIGHT)));
				if (worldIn.getCurrentMoonPhaseFactor() == .75) worldIn.setBlockState(pos, StartupCommon.blockMoonFlower4.getDefaultState().withProperty(NIGHT, iblockstate.getValue(NIGHT)));
				if (worldIn.getCurrentMoonPhaseFactor() == 1) worldIn.setBlockState(pos, StartupCommon.blockMoonFlower5.getDefaultState().withProperty(NIGHT, iblockstate.getValue(NIGHT)));
			}
			else {
				worldIn.setBlockState(pos, StartupCommon.blockMoonFlower.getDefaultState().withProperty(NIGHT, iblockstate.getValue(NIGHT)), 3);
			}
		}	
	}
	
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] {NIGHT});
    }
    
    
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(StartupCommon.blockMoonFlower);
    }
    
    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos) {
        return Item.getItemFromBlock(StartupCommon.blockMoonFlower);
    }
    
    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(NIGHT, Integer.valueOf(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state) {
        return ((Integer)state.getValue(NIGHT)).intValue();
    }
    
}
