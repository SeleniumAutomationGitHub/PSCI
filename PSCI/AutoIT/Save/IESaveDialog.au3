Do
If WinActive("[Class:IEFrame]") Then
        Local $hIE = WinGetHandle("[Class:IEFrame]")
        Local $hCtrl = ControlGetHandle($hIE, "", "[ClassNN:DirectUIHWND1]")
        Local $aPos = ControlGetPos($hIE, "", $hCtrl)
        Local $aWinPos = WinGetPos($hIE)
        If ControlCommand($hIE, "", $hCtrl, "IsVisible") AND $aPos[1] > .75 * $aWinPos[3] Then ; Check if the control is in the bottom 25% of the page.
            ControlClick($hIE, "", $hCtrl, "primary", 1, $aPos[2] - 160, $aPos[3] - 30)
            Sleep(500)
            ControlSend($hIE, "", $hCtrl, "!s")
			ExitLoop
		EndIf
    EndIf
sleep(100)
Until WinExists("Save As")

