package okw;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * \~german
 *  Annotations-Klasses für die Zuordnung von
 *  -# der \ref refFN -s 
 *  -# Wartezeiten für die Verify* -Schlüsselwörter
 *  -# Wartezeiten für das *erscheinen* von GUI-Objekten.
 *  zu einem GUI-Objekt im Frame.
 *  
 *  @see: http://tutorials.jenkov.com/java-reflection/annotations.html
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
   *  \ref refFN des GUI-Objektes.
   * 
   *  \~english
   *  \ref refFN of the GUI-Object.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2015-11-28
   */
  public String FN() default "";

  
  /**
   * \~german
   * <b>T</b>ime<b>O</b>ut in Sekunden [s] für das erscheinen des aktuellen Objektes.
   * Default ist 30s.
   */
  public int WaitForMe_TO() default 30;

  /**
   * \~german
   * <b>P</b>olling <b>T</b>ime in [ms] für das aktuelle Object.
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   * Default ist 1000ms (=1s).
   */
  public int WaitForMe_PT() default 1000;

  
  /**
   * \~german
   * <b>T</b>ime<b>O</b>ut in Sekunden [s] für das Schlüsselwort VerifyHasFocus.
   * Default ist 30s.
   */
  public int VerifyHasFocus_TO() default 30;

  /**
   * \~german
   * <b>P</b>olling <b>T</b>ime in [ms] für das Schlüsselwort VerifyHasFocus.
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   * Default ist 1000ms (=1s).
   */
  public int VerifyHasFocus_PT() default 1000;

  
  /**
   * \~german
   * <b>T</b>ime<b>O</b>ut in Sekunden [s] für das Schlüsselwort VerifyIsActive.
   * Default ist 30s.
   */
  public int VerifyIsActive_TO() default 30;

  /**
   * \~german
   * <b>P</b>olling <b>T</b>ime in [ms] für das Schlüsselwort VerifyIsActive.
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   * Default ist 1000ms (=1s).
   */
  public int VerifyIsActive_PT() default 1000;

  
  /**
   * \~german
   * <b>T</b>ime<b>O</b>ut in Sekunden [s] für das Schlüsselwort VerifyLabel.
   * Default ist 30s.
   */
  int VerifyLabel_TO() default 30;

  /**
   * \~german
   * <b>P</b>olling <b>T</b>ime in [ms] für das Schlüsselwort VerifyLabel.
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   * Default ist 1000ms (=1s).
   */
  int VerifyLabel_PT() default 1000;

  
  /**
   * \~german
   * <b>T</b>ime<b>O</b>ut in Sekunden [s] für das Schlüsselwort VerifySelectedValue.
   * Default ist 30s.
   */
  int VerifySelectedValue_TO() default 30;

  /**
   * \~german
   * <b>P</b>olling <b>T</b>ime in [ms] für das Schlüsselwort VerifySelectedValue.
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   * Default ist 1000ms (=1s).
   */
  int VerifySelectedValue_PT() default 1000;

  
  /**
   * \~german
   * <b>T</b>ime<b>O</b>ut in Sekunden [s] für das Schlüsselwort VerifyTablecellValue.
   * Default ist 30s.
   */
  int VerifyTablecellValue_TO() default 30;

  /**
   * \~german
   * <b>P</b>olling <b>T</b>ime in [ms] für das Schlüsselwort VerifyTablecellValue.
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   * Default ist 1000ms (=1s).
   */
  int VerifyTablecellValue_PT() default 1000;

  
  /**
   * \~german
   * <b>T</b>ime<b>O</b>ut in Sekunden [s] für das Schlüsselwort VerifyTooltip.
   * Default ist 30s.
   */
  int VerifyTooltip_TO() default 30;
  
  /**
   * \~german
   * <b>P</b>olling <b>T</b>ime in [ms] für das Schlüsselwort VerifyTooltip.
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   * Default ist 1000ms (=1s).
   */
  public int VerifyTooltip_PT() default 1000;

  /**
   * \~german
   * <b>T</b>ime<b>O</b>ut in Sekunden [s] für das Schlüsselwort VerifyValue.
   * Default ist 30s.
   */
  public int VerifyValue_TO() default 30;

  /**
   * \~german
   * <b>P</b>olling <b>T</b>ime in [ms] für das Schlüsselwort VerifyValue.
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   * Default ist 1000ms (=1s).
   */
  public int VerifyValue_PT() default 1000;

  /**
   * \~german
   * <b>T</b>ime<b>O</b>ut in Sekunden [s] für das Schlüsselwort VerifyCaption.
   * Default ist 30s.
   */
  public int VerifyCaption_TO() default 30;

  /**
   * \~german
   * <b>P</b>olling <b>T</b>ime in [ms] für das Schlüsselwort VerifyCaption.
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   * Default ist 1000ms (=1s).
   */
  public int VerifyCaption_PT() default 1000;

  /**
   * \~german
   * <b>T</b>ime<b>O</b>ut in Sekunden [s] für das Schlüsselwort VerifyExists.
   * Default ist 30s.
   */
  public int VerifyExists_TO() default 30;

  /**
   * \~german
   * <b>P</b>olling <b>T</b>ime in [ms] für das Schlüsselwort VerifyExists.
   *
   * Die Periodendauer des Pollens wird in Millisekunden angegeben.
   * Default ist 1000ms (=1s).
   */
  public int VerifyExists_PT() default 1000;

}