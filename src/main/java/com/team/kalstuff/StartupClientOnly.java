package com.team.kalstuff;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StartupClientOnly {
	
	public static void preInitClientOnly()
	{
		KeyBinding binding = new KeyBinding("key.kalstuff.test", 37, "key.categories.kalstuff");
		ClientRegistry.registerKeyBinding(binding);
	}
	
	public static void initClientOnly()
	{
		System.out.println("The item model has been succesfully loaded! Whoopy and hooray!");
		final int DEFAULT_ITEM_SUBTYPE = 0;
		
		Item itemBlockBridge = GameRegistry.findItem("kalstuff", "blockBridge");
		ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("kalstuff:blockBridge", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockBridge, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		ModelResourceLocation itemModelResourceLocation2 = new ModelResourceLocation("kalstuff:itemEnderPowder", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(StartupCommon.itemEnderPowder, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation2);
		 
		ModelResourceLocation itemModelResourceLocation3 = new ModelResourceLocation("kalstuff:itemCoffee", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(StartupCommon.itemCoffee, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation3);
		 
		ModelResourceLocation itemModelResourceLocation4 = new ModelResourceLocation("kalstuff:itemCoffeeMug", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(StartupCommon.itemCoffeeMug, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation4);
		//teasting
		Item itemBlockSquidMat = GameRegistry.findItem("kalstuff", "blockSquidMat");
		ModelResourceLocation itemModelResourceLocation5= new ModelResourceLocation("kalstuff:blockSquidMat", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockSquidMat, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation5);
		
		Item itemBlockEnder = GameRegistry.findItem("kalstuff", "blockEnder");
		ModelResourceLocation itemModelResourceLocation6= new ModelResourceLocation("kalstuff:blockEnder", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockEnder, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation6);
		
		ModelResourceLocation itemModelResourceLocation7 = new ModelResourceLocation("kalstuff:itemTea", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(StartupCommon.itemTea, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation7);
		
		ModelResourceLocation itemModelResourceLocation8 = new ModelResourceLocation("kalstuff:itemLightCoffee", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(StartupCommon.itemLightCoffee, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation8);
		
		Item itemBlockBlaze = GameRegistry.findItem("kalstuff", "blockBlaze");
		ModelResourceLocation itemModelResourceLocation9= new ModelResourceLocation("kalstuff:blockBlaze", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockBlaze, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation9);
		
		Item itemBlockCarrot = GameRegistry.findItem("kalstuff", "blockCarrot");
		ModelResourceLocation itemModelResourceLocation10= new ModelResourceLocation("kalstuff:blockCarrot", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockCarrot, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation10);
	
		Item itemBlockApple = GameRegistry.findItem("kalstuff", "blockApple");
		ModelResourceLocation itemModelResourceLocation11= new ModelResourceLocation("kalstuff:blockApple", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockApple, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation11);
	
		ModelResourceLocation itemModelResourceLocation12 = new ModelResourceLocation("kalstuff:itemGoldenMug", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(StartupCommon.itemGoldenMug, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation12);
		
		ModelResourceLocation itemModelResourceLocation13 = new ModelResourceLocation("kalstuff:itemJewelSoup", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(StartupCommon.itemJewelSoup, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation13);
		
		Item itemBlockPotato = GameRegistry.findItem("kalstuff", "blockPotato");
		ModelResourceLocation itemModelResourceLocation14 = new ModelResourceLocation("kalstuff:blockPotato", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockPotato, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation14);
	
		Item itemBlockChickenNest = GameRegistry.findItem("kalstuff", "blockChickenNest");
		ModelResourceLocation itemModelResourceLocation16 = new ModelResourceLocation("kalstuff:blockChickenNest", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockChickenNest, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation16);
	}
	 
	public static void postInitClientOnly()
	{
	}
	
}
