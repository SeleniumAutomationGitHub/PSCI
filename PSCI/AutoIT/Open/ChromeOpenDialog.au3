;#include <AutoItConstants.au3>
$hResult = WinActivate("[Class:Chrome_WidgetWin_1]");


	If($hResult == 0) Then
        _Log("Unable to click on excel file")

     Else

        ;To focus and select Save button if dialogue box have save radio button
 		MouseClick('primary', 67, 1018, 1, 0)


    EndIf