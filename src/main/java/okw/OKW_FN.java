package okw;

/// \~german
/// \brief Annotation @Interface für die Zuordnung des Fachlichen Name-s eines GUI-Objektes im Frame.
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
public @interface OKW_FN {

	/// \~german
    /// \brief_F_untionaler _N_ame des GUI-Objektes
    /// 
    /// \~english
    /// \brief Holds the Functional Name of the GUI-Object.
    ///
    /// \~
    /// \author Zoltan Hrabovszki
    /// \date 2015-11-28
	String FN() default "";
}