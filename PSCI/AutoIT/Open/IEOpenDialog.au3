$IEWin = WinActivate("[class:IEFrame]")

If($IEWin == 0)Then
	_Log("Unable to find Download Window From InternetExplorer")
Else
ControlFocus("Patient Care Recommendation Report - Internet Explorer", "", "DirectUIHWND1")
Sleep(500)
MouseClick('primary', '1231', '1021', 1, 0)

ElseIf

