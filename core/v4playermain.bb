Include "v4init.bb"

; Lotaris Player
; Copyright 2018 Cosmo



Global game$=OpenFile(playerfile)
Global px=0
Global py=0 
Global ocolourr=0
Global ocolourg=0
Global ocolourb=0 



Delay 750 ; why not
count=1


Global lpwin = CreateWindow("Lotaris Player " + version + "." + build + "." + revision + " [BETA]",50,32,1024,768,0,15)
Global gamec = CreateCanvas(0,0,1024,768,lpwin)
SetBuffer CanvasBuffer(gamec)
Global lpwm = WindowMenu(lpwin)
lpwm_debugmenu = CreateMenu("Debug",0,lpwm)
CreateMenu "Kill Player",500,lpwm_debugmenu
CreateMenu "Restart",501,lpwm_debugmenu
CreateMenu "Set Health 10%",502,lpwm_debugmenu
CreateMenu "Set Health 50%",503,lpwm_debugmenu
CreateMenu "Set Health 100%",504,lpwm_debugmenu
CreateMenu "Set Health 150%",505,lpwm_debugmenu
CreateMenu "Set Health 200%",506,lpwm_debugmenu
CreateMenu "Set Health 300%",507,lpwm_debugmenu
CreateMenu "Spawn Block at (512,384) size(32,32) colour(128,128,128)",508,lpwm_debugmenu
CreateMenu "Force Player to Block XY Y+PSIZEY",509,lpwm_debugmenu
CreateMenu "Wipe Map",510,lpwm_debugmenu
CreateMenu "Force Load",511,lpwm_debugmenu
CreateMenu "Force Exit",512,lpwm_debugmenu
CreateMenu "Force Splash Screen",513,lpwm_debugmenu
CreateMenu "Force Console Log",514,lpwm_debugmenu



load_map_information()

Function load_map_information()
currentfile$ = RequestFile("Open game","ldfl",False)
If currentfile$ = 0
debug_throw_error_and_crash_violently("v4save.bb -> function load_map_information() -> currentfile$ = RequestFile('Save game', 'ldfl', False): No file chosen", 18)
EndIf

currentfile2$ = OpenFile(currentfile$)
SeekFile currentfile2$, 0
checksum2$ = ReadLine(currentfile2$)

If checksum2$ <> "Lotaris-Dataformat v1.2"
debug_throw_error_and_crash_violently("v4save.bb -> function load_map_information() -> checksum2 = ReadLine(currentfile$): File is corrupt, header missing or corrupt, file cannot be loaded", 19)
EndIf

Cls
Delay 750 ; why not
count=1
While Not Eof(currentfile2$)



b.block = New block

sbtype = Int ReadLine(currentfile2$)
sx = Int ReadLine(currentfile2$)
sy = Int ReadLine(currentfile2$)
bsx = Int ReadLine(currentfile2$)
bsy = Int ReadLine(currentfile2$)
bcr = Int ReadLine(currentfile2$)
bcg = Int ReadLine(currentfile2$)
bcb = Int ReadLine(currentfile2$)
bmt = Int ReadLine(currentfile2$)
ReadLine(currentfile2$)
b\blocktype = sbtype
b\x = sx
b\y = sy
b\sizex = bsx
b\sizey = bsy
b\colourr = bcr
b\colourg = bcg
b\colourb = bcb
b\mtex = mtex
Color b\colourr, b\colourg, b\colourb
Rect b\x,b\y,b\sizex,b\sizey,1
Color ocolourr, ocolourg, ocolourb
count = count+1 


Wend

p.player = New player
p\px=0
p\py=0
p\phealth=100
p\parmor=0
p\pdead=0
p\pdeath=0
p\pjumpheight=12
p\pjumpaccel=0.005
p\pspeed=1
p\paccel=0.005
p\pded=0


Notify("load complete")
Return 
End Function

ocolourr=ColorRed()
ocolourg=ColorGreen()
ocolourb=ColorBlue()


Repeat
Color 255,0,0
eRect p\px, p\py, 32, 32, 1
Color ocolourr, ocolourg, ocolourb
FlipCanvas(gamec) 
MovePlayer()
Forever


Function MovePlayer()

If KeyDown(17) y=y+1
If KeyDown(30) x=x-1
If KeyDown(31) y=y-1
If KeyDown(32) x=x+1
p\x=x
p\y=y
End Function