;#include <AutoItConstants.au3>
$hResult = WinActivate("[Class:XLMAIN]");


	If($hResult == 0) Then
        _Log("Unable to click on excel file")

     Else

        ;To focus and select Save button if dialogue box have save radio button
 		;MouseClick('primary', 1621, 167, 1, 0)

		;To focus and click on Close icon button in opened excel file
 		MouseClick('primary', 1893, 9, 1, 0)
		Sleep(400)
		ControlClick("Microsoft Office Excel", "", "Button2")

    EndIf

