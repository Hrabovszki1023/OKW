package okw;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/// \~german
/// \brief Annotation @Interface für die Zuordnung des Fachlichen Name-s eines GUI-Objektes im Frame.
/// \see; http://tutorials.jenkov.com/java-reflection/annotations.html
/// == github Issue
/// issue https://github.com/Hrabovszki1023/OKW/issues/37
///
/// \~english
/// \brief
///
/// \~
/// \author Zoltan Hrabovszki
/// \date 2015-11-28

@Target(
{ ElementType.TYPE, // Usable in Class-es
        ElementType.FIELD } )
// Usable in Field-s
@Inherited
@Retention( RetentionPolicy.RUNTIME )
public @interface OKW
{

  // / \~german
  // / \brief _F_untionaler _N_ame des GUI-Objektes
  // /
  // / \~english
  // / \brief Holds the Functional Name of the GUI-Object.
  // /
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2015-11-28
  public String FN() default "";

  /**
   * TimeOut in Secunden [s] für das Schlüsselwort VerifyHasFocus. Default ist
   * 30s. in [s]
   */
  public int VerifyHasFocus_TO() default 30;

  /**
   * Polling Time in [ms].
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   */
  public int VerifyHasFocus_PT() default 1000;

  /**
   * TimeOut in [s]
   */
  public int VerifyIsActive_TO() default 30;

  /**
   * Polling Time in [ms].
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   */
  public int VerifyIsActive_PT() default 1000;

  /**
   * TimeOut in [s]
   */
  int VerifyLabel_TO() default 30;

  /**
   * Polling Time in [ms].
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   */
  int VerifyLabel_PT() default 1000;

  /**
   * TimeOut in [s]
   */
  int VerifySelectedValue_TO() default 30;

  /**
   * Polling Time in [ms].
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   */
  int VerifySelectedValue_PT() default 1000;

  /**
   * TimeOut in [s]
   */
  int VerifyTooltip_TO() default 30;

  /**
   * Polling Time in [ms].
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   */
  public int VerifyTooltip_PT() default 1000;

  /**
   * TimeOut in [s]
   */
  public int VerifyValue_TO() default 30;

  /**
   * Polling Time in [ms].
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   */
  public int VerifyValue_PT() default 1000;

  /**
   * TimeOut in [s]
   */
  public int VerifyCaption_TO() default 30;

  /**
   * Polling Time in [ms].
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   */
  public int VerifyCaption_PT() default 1000;

  /**
   * TimeOut in [s]
   */
  public int VerifyExists_TO() default 30;

  /**
   * Polling Time in [ms].
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   */
  public int VerifyExists_PT() default 1000;

}