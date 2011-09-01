package org.atatec.jboss.logger;

import org.jboss.ejb3.annotation.Management;

/**
 * Interface that exposes the JMX management methods for the Logger Service
 *
 * @author Marcelo Guimaraes <ataxexe@gmail.com>
 */
@Management
public interface LoggerService {

  /**
   * Returns the default category used if no one is specified.
   *
   * @return the default category.
   */
  String getDefaultCategory();

  /**
   * Sets the default category to use if no one is specified.
   *
   * @param category
   *          the category to use as default
   */
  void setDefaultCategory(String category);

  /**
   * Logs the given message using the FATAL level and the default category.
   *
   * @param message
   *          the message to log
   */
  void fatal(String message);

  /**
   * Logs the given message using the FATAL level and the given category.
   *
   * @param category
   *          the category to use
   * @param message
   *          the message to log
   */
  void fatal(String category, String message);

  /**
   * Logs the given message using the FATAL level, the given category and the
   * given exception class as the cause. If the exception does not exist in
   * classpath, it will be created at runtime (if possible).
   *
   * @param category
   *          the category to use
   * @param message
   *          the message to log
   * @param exceptionClass
   *          the cause exception
   */
  void fatal(String category, String message, String exceptionClass)
      throws Exception;

  /**
   * Logs the given message using the ERROR level and the default category.
   *
   * @param message
   *          the message to log
   */
  void error(String message);

  /**
   * Logs the given message using the ERROR level and the given category.
   *
   * @param category
   *          the category to use
   * @param message
   *          the message to log
   */
  void error(String category, String message);

  /**
   * Logs the given message using the ERROR level, the given category and the
   * given exception class as the cause. If the exception does not exist in
   * classpath, it will be created at runtime (if possible).
   *
   * @param category
   *          the category to use
   * @param message
   *          the message to log
   * @param exceptionClass
   *          the cause exception
   */
  void error(String category, String message, String exceptionClass)
      throws Exception;

  /**
   * Logs the given message using the WARN level and the default category.
   *
   * @param message
   *          the message to log
   */
  void warn(String message);

  /**
   * Logs the given message using the WARN level and the given category.
   *
   * @param category
   *          the category to use
   * @param message
   *          the message to log
   */
  void warn(String category, String message);

  /**
   * Logs the given message using the WARN level, the given category and the
   * given exception class as the cause. If the exception does not exist in
   * classpath, it will be created at runtime (if possible).
   *
   * @param category
   *          the category to use
   * @param message
   *          the message to log
   * @param exceptionClass
   *          the cause exception
   */
  void warn(String category, String message, String exceptionClass)
      throws Exception;

  /**
   * Logs the given message using the INFO level and the default category.
   *
   * @param message
   *          the message to log
   */
  void info(String message);

  /**
   * Logs the given message using the INFO level and the given category.
   *
   * @param category
   *          the category to use
   * @param message
   *          the message to log
   */
  void info(String category, String message);

  /**
   * Logs the given message using the INFO level, the given category and the
   * given exception class as the cause. If the exception does not exist in
   * classpath, it will be created at runtime (if possible).
   *
   * @param category
   *          the category to use
   * @param message
   *          the message to log
   * @param exceptionClass
   *          the cause exception
   */
  void info(String category, String message, String exceptionClass)
      throws Exception;

  /**
   * Logs the given message using the DEBUG level and the default category.
   *
   * @param message
   *          the message to log
   */
  void debug(String message);

  /**
   * Logs the given message using the DEBUG level and the given category.
   *
   * @param category
   *          the category to use
   * @param message
   *          the message to log
   */
  void debug(String category, String message);

  /**
   * Logs the given message using the DEBUG level, the given category and the
   * given exception class as the cause. If the exception does not exist in
   * classpath, it will be created at runtime (if possible).
   *
   * @param category
   *          the category to use
   * @param message
   *          the message to log
   * @param exceptionClass
   *          the cause exception
   */
  void debug(String category, String message, String exceptionClass)
      throws Exception;

  /**
   * Logs the given message using the TRACE level and the default category.
   *
   * @param message
   *          the message to log
   */
  void trace(String message);

  /**
   * Logs the given message using the TRACE level and the given category.
   *
   * @param category
   *          the category to use
   * @param message
   *          the message to log
   */
  void trace(String category, String message);

  /**
   * Logs the given message using the TRACE level, the given category and the
   * given exception class as the cause. If the exception does not exist in
   * classpath, it will be created at runtime (if possible).
   *
   * @param category
   *          the category to use
   * @param message
   *          the message to log
   * @param exceptionClass
   *          the cause exception
   */
  void trace(String category, String message, String exceptionClass)
      throws Exception;

}
