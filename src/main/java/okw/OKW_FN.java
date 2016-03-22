package okw;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/// \~german
/// \brief Annotation @Interface für die Zuordnung des Fachlichen Name-s eines GUI-Objektes im Frame.
/// \see; http://tutorials.jenkov.com/java-reflection/annotations.html
/// == github Issue
/// Refernz zum github issue https://github.com/Hrabovszki1023/OKW/issues/37
///
/// \~english
/// \brief
///
/// \~
/// \author Zoltan Hrabovszki
/// \date 2015-11-28
/// @Target( { java.lang.annotation.ElementType., java.lang.annotation.ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
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
	public String FN() default "";
}