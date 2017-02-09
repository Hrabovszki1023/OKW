package okw;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/** \~german
 *  Annotation @Interface für die Zuordnung des Fachlichen Name-s eines GUI-Objektes im Frame.
 *  \see: http://tutorials.jenkov.com/java-reflection/annotations.html
 *  == github Issue
 *  issue https://github.com/Hrabovszki1023/OKW/issues/37
 * 
 *  \~english
 *  \brief
 * 
 *  \~
 *  @author Zoltan Hrabovszki
 *  @date 2015-11-28
 */

@Target(
{ 
  ElementType.TYPE, // Usable in Class-es
  ElementType.FIELD } )

// Usable in Field-s
@Inherited
@Retention( RetentionPolicy.RUNTIME )
public @interface OKW
{

  /**
   * \~german
   *  _F_untionaler _N_ame des GUI-Objektes.
   * 
   *  \~english
   *  Functional Name of the GUI-Object.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2015-11-28
   */
  public String FN() default "";

  
  /**
   * \~german
   * _T_ime_O_ut in Secunden [s] für das aktuelle Object.
   * Default ist 30s.
   */
  public int WaitForMe_TO() default 30;

  /**
   * \~german
   * _P_olling _T_ime in [ms] für das aktuelle Object.
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   * Default ist 1000ms (=1s).
   */
  public int WaitForMe_PT() default 1000;

  
  /**
   * \~german
   * _T_ime_O_ut in Secunden [s] für das Schlüsselwort VerifyHasFocus.
   * Default ist 30s.
   */
  public int VerifyHasFocus_TO() default 30;

  /**
   * \~german
   * _P_olling _T_ime in [ms] für das Schlüsselwort VerifyHasFocus.
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   * Default ist 1000ms (=1s).
   */
  public int VerifyHasFocus_PT() default 1000;

  
  /**
   * \~german
   * _T_ime_O_ut in [s] für das Schlüsselwort VerifyIsActive.
   * Default ist 30s.
   */
  public int VerifyIsActive_TO() default 30;

  /**
   * \~german
   * Polling Time in [ms] für das Schlüsselwort VerifyIsActive.
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   * Default ist 1000ms (=1s).
   */
  public int VerifyIsActive_PT() default 1000;

  
  /**
   * \~german
   * TimeOut in [s] für das Schlüsselwort VerifyLabel.
   * Default ist 30s.
   */
  int VerifyLabel_TO() default 30;

  /**
   * \~german
   * Polling Time in [ms] für das Schlüsselwort VerifyLabel.
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   * Default ist 1000ms (=1s).
   */
  int VerifyLabel_PT() default 1000;

  
  /**
   * \~german
   * TimeOut in [s] für das Schlüsselwort VerifySelectedValue.
   * Default ist 30s.
   */
  int VerifySelectedValue_TO() default 30;

  /**
   * \~german
   * Polling Time in [ms] für das Schlüsselwort VerifySelectedValue.
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   * Default ist 1000ms (=1s).
   */
  int VerifySelectedValue_PT() default 1000;

  /**
   * \~german
   * TimeOut in [s] für das Schlüsselwort VerifyTooltip.
   * Default ist 30s.
   */
  int VerifyTooltip_TO() default 30;

  
  /**
   * \~german
   * Polling Time in [ms] für das Schlüsselwort VerifyTooltip.
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   * Default ist 1000ms (=1s).
   */
  public int VerifyTooltip_PT() default 1000;

  /**
   * \~german
   * TimeOut in [s] für das Schlüsselwort VerifyValue.
   * Default ist 30s.
   */
  public int VerifyValue_TO() default 30;

  /**
   * \~german
   * Polling Time in [ms] für das Schlüsselwort VerifyValue.
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   * Default ist 1000ms (=1s).
   */
  public int VerifyValue_PT() default 1000;

  /**
   * \~german
   * TimeOut in [s] für das Schlüsselwort VerifyCaption.
   * Default ist 30s.
   */
  public int VerifyCaption_TO() default 30;

  /**
   * \~german
   * Polling Time in [ms] für das Schlüsselwort VerifyCaption.
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   * Default ist 1000ms (=1s).
   */
  public int VerifyCaption_PT() default 1000;

  /**
   * \~german
   * TimeOut in [s] für das Schlüsselwort VerifyExists.
   * Default ist 30s.
   */
  public int VerifyExists_TO() default 30;

  /**
   * \~german
   * Polling Time in [ms] für das Schlüsselwort VerifyExists.
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   * Default ist 1000ms (=1s).
   */
  public int VerifyExists_PT() default 1000;

}