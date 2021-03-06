Include "v4init.bb"

logtoconsole("Lotaris Client. Version " + version# + "." + build + "." + revision + ".")
If releasemode=0
logtoconsole("Debug Release")
ElseIf releasemode=1
logtoconsole("External Beta")
ElseIf releasemode=2
logtoconsole("Release")
EndIf
logtoconsole("Starting...")
If releasemode <> 2 Notify("WARNING: You are about to initialize pre-release software. There may be bugs and incompatibilities. ENTER AT YOUR OWN RISK.")


Global lwin = CreateWindow("Lotaris " + version + "." + build + "." + revision + " [BETA]",50,32,1024,768,0,15)
Global game = CreateCanvas(0,0,1024,768,lwin)
Global lwm = WindowMenu(lwin)
; WINDOW MENUS
Global lwm_gamemenu = CreateMenu("Game",0,lwm)
CreateMenu "New Game...",1,lwm_gamemenu
CreateMenu "Open Game...",2,lwm_gamemenu
CreateMenu "Save Game...",3,lwm_gamemenu
CreateMenu "Save Game As...",4,lwm_gamemenu
CreateMenu "Configure Game Information...",5,lwm_gamemenu
Global lwm_toolsmenu = CreateMenu("Tools",100,lwm)
CreateMenu "Change Brick Colour...",101,lwm_toolsmenu
CreateMenu "Change/Set Brick Material...",102,lwm_toolsmenu
CreateMenu "Change Brick Size...",103,lwm_toolsmenu
CreateMenu "Change Grid Size...",104,lwm_toolsmenu
CreateMenu "Special Bricks...",105,lwm_toolsmenu
CreateMenu "Erase Tool",106,lwm_toolsmenu
CreateMenu "Effect Tool",107,lwm_toolsmenu
CreateMenu "Game Settings...",108,lwm_toolsmenu
Global lwm_uploadmenu = CreateMenu("Upload",200,lwm)
CreateMenu "Upload to Lotaris...",201,lwm_uploadmenu
CreateMenu "Upload to Lotaris as...",202,lwm_uploadmenu
CreateMenu "Manage Games...",203,lwm_uploadmenu  ;if htmlview worked this would be way way better [we can use BMX for this]
Global lwm_helpmenu = CreateMenu("Help",300,lwm)
CreateMenu "Help...",301,lwm_helpmenu
CreateMenu "Visit Lotaris...",302,lwm_helpmenu
CreateMenu "Application Source on GitHub",303,lwm_helpmenu
If releasemode<2
CreateMenu "Debug Settings",304,lwm_helpmenu
EndIf

Global lwm_aboutmenu = CreateMenu("About",400,lwm)
CreateMenu "Check for Updates...",401,lwm_aboutmenu
CreateMenu "About...",402,lwm_aboutmenu

SetBuffer CanvasBuffer(game)

Global bsmenu = CreateWindow("Change current brick size",50,50,400,200,lwin,15) 
bsmenut1 = CreateTextField(70,20,150,18,bsmenu,0)
bsmenut2 = CreateTextField(70,90,150,18,bsmenu,0)
bsmenul1 = CreateLabel("X size: ",30,20,32,32,bsmenu,0)
bamenul2 = CreateLabel("Y size: ",30,90,32,32,bsmenu,0)
Global bgmenu = CreateWindow("Change current grid size",100,100,400,200,lwin,15)
bgmenut1 = CreateTextField(70,20,150,18,bgmenu,0)
bgmenut2 = CreateTextField(70,90,150,18,bgmenu,0)
bgmenul1 = CreateLabel("X size: ",30,20,32,32,bgmenu,0)
bgmenul2 = CreateLabel("Y size: ",30,90,32,32,bgmenu,0)
fxmenu = CreateWindow("Part FX",50,50,400,200,fxmenu,15)
fxmenulb1 = CreateComboBox(45,45,130,18,fxmenu,0)
fxmenul1 = CreateLabel("Select FX: ",0,45,32,64,fxmenu,0)
AddGadgetItem fxmenulb1,"Transparent 75%"
AddGadgetItem fxmenulb1,"Transparent 50%"
AddGadgetItem fxmenulb1,"Transparent 25%"
AddGadgetItem fxmenulb1,"Gradient"
AddGadgetItem fxmenulb1,"Sparkles"
AddGadgetItem fxmenulb1,"Fire"
AddGadgetItem fxmenulb1,"Wet"
AddGadgetItem fxmenulb1,"Very Wet"
AddGadgetItem fxmenulb1,"Burnt"
AddGadgetItem fxmenulb1,"Cracked"
AddGadgetItem fxmenulb1,"Mossy"
AddGadgetItem fxmenulb1,"Gravel"
AddGadgetItem fxmenulb1,"Window"
AddGadgetItem fxmenulb1,"Bright Light"
AddGadgetItem fxmenulb1,"Shiny"
mtmenu = CreateWindow("Materials",50,50,400,400,lwin,15)
mtmenulb1 = CreateComboBox(65,45,130,18,mtmenu,0)
mtmenul1 = CreateLabel("Select Mat: ",0,55,32,64,mtmenu,0)
Global sbmenu = CreateWindow("Special Brick Select",50,50,400,400,lwin,15)
HideGadget bsmenu
HideGadget bgmenu
HideGadget fxmenu
HideGadget mtmenu
HideGadget sbmenu

DisableGadget bsmenu
DisableGadget bgmenu
DisableGadget fxmenu
DisableGadget mtmenu
DisableGadget sbmenu

logtoconsole("Reading materials...")
v4readmaterials()
LogToConsole("Initialization complete.")
; stop weird internal errors 