; my soul your beats by dr.dre
SeedRnd MilliSecs()
AppTitle("SLIDE UP IN DEM DMSSSSSSSSSSSS Simulator v1.0 - Press ESC to exit")
Global s1$,s2$,s3$,s4$
Global rngs1=0
Global rngs2=0
Global rngs3=0
Global rngs4=0
Function robotrant_internal_loop()
rngs1=Rnd(0,2) ; Segment01 Content
rngs2=Rnd(0,3) ; Segment02 Content
rngs3=Rnd(0,10) ; Segment03 Content
rngs4=Rnd(0,0) ; Message Delay
rngs5=Rnd(0,1000) ; Borislav Autocrashing TechnologyTM
If rngs1 = rngs2
	While rngs1 = rngs2
		rngs2=Rnd(0,3)
	Wend
EndIf

If rngs1 = 0 s1$="ec_ho: "
If rngs1 = 1 s1$="borislav: "
If rngs1 = 2 s1$="cosmo: "
If rngs2 = 0 s2$="@borislav "
If rngs2 = 1 s2$="@cosmo "
If rngs2 = 2 s2$="@ec_ho "
If rngs2 = 3 s2$="@everyone "
If rngs3 = 0 s3$="boris johnson "
If rngs3 = 1 s3$="bori slav "
If rngs3 = 2 s3$="not sego memes "
If rngs3 = 3 s3$="yuri "
If rngs3 = 4 s3$="lotaris will be coming soon "
If rngs3 = 5 s3$="lotaris "
If rngs3 = 6 s3$="i need to do what has to be done by me to help my brother to defeat the enemys " 
If rngs3 = 7 s3$="urbisworld "
If rngs3 = 8 s3$="cityworld "
If rngs3 = 9 s3$="borislav "
If rngs3 = 10 s3$="borislav "
s4$ = CurrentDate() + " " + CurrentTime()
DebugLog("rng segment #5 " + rngs5)
If rngs5 < 1
RuntimeError("This program has been crashed by Borislav Auto-Crashing Technology")
EndIf
Print(s1$ + s2$ + s3$)
Print("[" + s4$ + "]")
End Function

While Not KeyHit(1)
robotrant_internal_loop()
Delay rngs4
Wend


 

