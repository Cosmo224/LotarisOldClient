

Function create_block(colourr,colourg,colourb,ismaterial)
; TODO post-Beta 1: Move to other block [1.0.305.0]
x = MouseX(game)
y = MouseY(game)
b.block = New block
b\x = MouseX(game)
b\y = MouseY(game)
b\sizex = sizex
b\sizey = sizey
b\blocktype = blocktype
b\colourr = colourr
b\colourg = colourg
b\colourb = colourb

b\mtex = 0
b\filled = 1

x = Round#(x, gsizex)
y = Round#(y, gsizey)
b\x=x
b\y=y
If b\x < 0 b\x = 0
If b\y < 0 b\y = 0


Select b\blocktype
Case 0 
Color b\colourr, b\colourg, b\colourb
Rect b\x,b\y,b\sizex,b\sizey,b\filled
Color ocolourr, ocolourg, ocolourb

logtoconsole("Inserting BLOCK at X:" + b\x + " Y:" + b\y + " with colour " + b\colourr + " " + b\colourg + " " + b\colourb + " with size X:" + b\sizex + " Y:" + b\sizey + " with grid size X:" + gsizex + " Y:" + gsizey)
Case 1 ; Erase
Color 0, 0, 0

Rect b\x,b\y,32,48,1
Color ocolourr, ocolourg, ocolourb
Case 2
logtoconsole("Inserting Material with MaterialID " + v4currentmaterial)
For m.material = Each material ; hacky shit
	temp = Int m\v4mid$
	If temp = v4currentmaterial
		b.block = New block
		; TODO: [1.0.281.0 or so]: Material scaling
		; ALSO TODO: Move code to other function [DONE 1.0.286.0] [NOT POSSIBLE - 1.0.287.0]
		x = MouseX(game)
		y = MouseY(game)
		x = Round#(x, gsizex)
		y = Round#(y, gsizey)
		temp6# = sizex / 32
	
		b\x=x
		b\y=y
		DrawImage m\v4mimage,b\x,b\y
	EndIf
Next
Case 3
Case 4

End Select 
gamestate=1


 
Return 
End Function

Function v4setblockparams()
End Function