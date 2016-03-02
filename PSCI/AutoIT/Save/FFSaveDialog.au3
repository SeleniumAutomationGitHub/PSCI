$hResult = WinActivate("[Class:MozillaDialogClass]");


	If($hResult == 0) Then
        _Log("Unable to find Download Window From FireFox")

     Else

        ;To focus and select Save button if dialogue box have save radio button
        Send("!s")
		;Click on Enter to Save
        Sleep(400)
        Send("{ENTER}")

    EndIf

