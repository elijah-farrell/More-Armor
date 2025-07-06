@echo off
echo Copying Galaxy armor textures...

REM Copy armor layer textures
copy "Tates CustomArmorAndElytras\assets\minecraft\optifine\cit\armors\galaxy_armor\galaxy_layer_1.png" "src\main\resources\assets\vanillaplus\textures\item\armor\galaxy_layer_1.png"
copy "Tates CustomArmorAndElytras\assets\minecraft\optifine\cit\armors\galaxy_armor\galaxy_layer_1_e.png" "src\main\resources\assets\vanillaplus\textures\item\armor\galaxy_layer_1_e.png"
copy "Tates CustomArmorAndElytras\assets\minecraft\optifine\cit\armors\galaxy_armor\galaxy_layer_2.png" "src\main\resources\assets\vanillaplus\textures\item\armor\galaxy_layer_2.png"
copy "Tates CustomArmorAndElytras\assets\minecraft\optifine\cit\armors\galaxy_armor\galaxy_layer_2_e.png" "src\main\resources\assets\vanillaplus\textures\item\armor\galaxy_layer_2_e.png"

REM Copy item textures
copy "Tates CustomArmorAndElytras\assets\minecraft\optifine\cit\armors\galaxy_armor\items\galaxy_helmet.png" "src\main\resources\assets\vanillaplus\textures\item\galaxy_helmet.png"
copy "Tates CustomArmorAndElytras\assets\minecraft\optifine\cit\armors\galaxy_armor\items\galaxy_chestplate.png" "src\main\resources\assets\vanillaplus\textures\item\galaxy_chestplate.png"
copy "Tates CustomArmorAndElytras\assets\minecraft\optifine\cit\armors\galaxy_armor\items\galaxy_leggings.png" "src\main\resources\assets\vanillaplus\textures\item\galaxy_leggings.png"
copy "Tates CustomArmorAndElytras\assets\minecraft\optifine\cit\armors\galaxy_armor\items\galaxy_boots.png" "src\main\resources\assets\vanillaplus\textures\item\galaxy_boots.png"

REM Copy enchantment glow item textures
copy "Tates CustomArmorAndElytras\assets\minecraft\optifine\cit\armors\galaxy_armor\items\galaxy_helmet_e.png" "src\main\resources\assets\vanillaplus\textures\item\galaxy_helmet_e.png"
copy "Tates CustomArmorAndElytras\assets\minecraft\optifine\cit\armors\galaxy_armor\items\galaxy_chestplate_e.png" "src\main\resources\assets\vanillaplus\textures\item\galaxy_chestplate_e.png"
copy "Tates CustomArmorAndElytras\assets\minecraft\optifine\cit\armors\galaxy_armor\items\galaxy_leggings_e.png" "src\main\resources\assets\vanillaplus\textures\item\galaxy_leggings_e.png"
copy "Tates CustomArmorAndElytras\assets\minecraft\optifine\cit\armors\galaxy_armor\items\galaxy_boots_e.png" "src\main\resources\assets\vanillaplus\textures\item\galaxy_boots_e.png"

REM Copy animation metadata files
copy "Tates CustomArmorAndElytras\assets\minecraft\optifine\cit\armors\galaxy_armor\items\galaxy_helmet.png.mcmeta" "src\main\resources\assets\vanillaplus\textures\item\galaxy_helmet.png.mcmeta"
copy "Tates CustomArmorAndElytras\assets\minecraft\optifine\cit\armors\galaxy_armor\items\galaxy_chestplate.png.mcmeta" "src\main\resources\assets\vanillaplus\textures\item\galaxy_chestplate.png.mcmeta"
copy "Tates CustomArmorAndElytras\assets\minecraft\optifine\cit\armors\galaxy_armor\items\galaxy_leggings.png.mcmeta" "src\main\resources\assets\vanillaplus\textures\item\galaxy_leggings.png.mcmeta"
copy "Tates CustomArmorAndElytras\assets\minecraft\optifine\cit\armors\galaxy_armor\items\galaxy_boots.png.mcmeta" "src\main\resources\assets\vanillaplus\textures\item\galaxy_boots.png.mcmeta"

echo Textures copied successfully!
pause 