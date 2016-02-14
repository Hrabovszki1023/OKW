package okw;

/// \~german
/// \brief Annotation @Interface für die Zuordnung GUI-Spezifishe Zuordnung von TimeOuts.
/// 
/// == github Issue
/// Refernz zum github issue https://github.com/Hrabovszki1023/OKW/issues/37
///
/// \~english
/// \brief
///
/// \~
/// \author Zoltan Hrabovszki
/// \date 2015-11-28
public @interface OKW_Timeout {

	/* \~german
	 *  \brief Timeout für GUI-Schlüsselwort VerifyCaption() 
	 *  
	 *  \~english
	 *  \brief Timeout for the GUI-KeyWord VerifyCaption() 
	 *  \~
	 *  \author Zoltan Hrabovszki
	 *  \date 2015-11-28
	 */
	int Caption();

	/* \~german
	 *  \brief Timeout für GUI-Schlüsselwort VerifyExists() 
	 *  
	 *  \~english
	 *  \brief Timeout for the GUI-KeyWord VerifyExists() 
	 *  \~
	 *  \author Zoltan Hrabovszki
	 *  \date 2015-11-28
	 */
	int Exists();

	/* \~german
	 *  \brief Timeout für GUI-Schlüsselwort VerifyHasFocus() 
	 *  
	 *  \~english
	 *  \brief Timeout for the GUI-KeyWord VerifyHasFocus() 
	 *  \~
	 *  \author Zoltan Hrabovszki
	 *  \date 2015-11-28
	 */
	int HasFocus();

	/* \~german
	 *  \brief Timeout für GUI-Schlüsselwort VerifyHasFocus() 
	 *  
	 *  \~english
	 *  \brief Timeout for the GUI-KeyWord VerifyHasFocus() 
	 *  \~
	 *  \author Zoltan Hrabovszki
	 *  \date 2015-11-28
	 */
	int IsActive();

	/* \~german
	 *  \brief Timeout für GUI-Schlüsselwort VerifyLabel() 
	 *  
	 *  \~english
	 *  \brief Timeout for the GUI-KeyWord VerifyLabel() 
	 *  \~
	 *  \author Zoltan Hrabovszki
	 *  \date 2015-11-28
	 */
	int Label();

	/* \~german
	 *  \brief Timeout für GUI-Schlüsselwort VerifySelectedValue() 
	 *  
	 *  \~english
	 *  \brief Timeout for the GUI-KeyWord VerifySelectedValue() 
	 *  \~
	 *  \author Zoltan Hrabovszki
	 *  \date 2015-11-28
	 */
	int SelectedValue();

	/* \~german
	 *  \brief Timeout für GUI-Schlüsselwort VerifyTablecellValue() 
	 *  
	 *  \~english
	 *  \brief Timeout for the GUI-KeyWord VerifyTablecellValue() 
	 *  \~
	 *  \author Zoltan Hrabovszki
	 *  \date 2015-11-28
	 */
	int TablecellValue();

	/* \~german
	 *  \brief Timeout für GUI-Schlüsselwort VerifyTooltip() 
	 *  
	 *  \~english
	 *  \brief Timeout for the GUI-KeyWord VerifyTooltip() 
	 *  \~
	 *  \author Zoltan Hrabovszki
	 *  \date 2015-11-28
	 */
	int Tooltip();

	/* \~german
	 *  \brief Timeout für GUI-Schlüsselwort VerifyValue() 
	 *  
	 *  \~english
	 *  \brief Timeout for the GUI-KeyWord VerifyValue() 
	 *  \~
	 *  \author Zoltan Hrabovszki
	 *  \date 2015-11-28
	 */
	int Value();

}
