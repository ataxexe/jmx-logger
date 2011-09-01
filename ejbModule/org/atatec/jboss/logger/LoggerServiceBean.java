package org.atatec.jboss.logger;

import java.lang.reflect.Constructor;

import javassist.ClassPool;
import javassist.CtClass;

import org.jboss.ejb3.annotation.Service;
import org.jboss.logging.Logger;

/**
 * The service class for Logger Service.
 *
 * @author Marcelo Guimaraes <ataxexe@gmail.com>
 *
 */
@Service(objectName = "jboss.system:service=Logging,type=Logger")
public class LoggerServiceBean implements LoggerService {

  /**
   * The default category, used if no one is specified.
   */
  String defaultCategory = "LOGGER";

  public String getDefaultCategory() {
    return defaultCategory;
  }

  public void setDefaultCategory(String defaultCategory) {
    this.defaultCategory = defaultCategory;
  }

  public void fatal(String message) {
    fatal(defaultCategory, message);
  }

  public void fatal(String category, String message) {
    log(category, LogLevel.FATAL, message);
  }

  public void fatal(String category, String message, String exceptionClass)
      throws Exception {
    log(category, LogLevel.FATAL, message, exceptionClass);
  }

  public void error(String message) {
    error(defaultCategory, message);
  }

  public void error(String category, String message) {
    log(category, LogLevel.ERROR, message);
  }

  public void error(String category, String message, String exceptionClass)
      throws Exception {
    log(category, LogLevel.ERROR, message, exceptionClass);
  }

  public void warn(String message) {
    warn(defaultCategory, message);
  }

  public void warn(String category, String message) {
    log(category, LogLevel.WARN, message);
  }

  public void warn(String category, String message, String exceptionClass)
      throws Exception {
    log(category, LogLevel.WARN, message, exceptionClass);
  }

  public void info(String message) {
    info(defaultCategory, message);
  }

  public void info(String category, String message) {
    log(category, LogLevel.INFO, message);
  }

  public void info(String category, String message, String exceptionClass)
      throws Exception {
    log(category, LogLevel.INFO, message, exceptionClass);
  }

  public void debug(String message) {
    debug(defaultCategory, message);
  }

  public void debug(String category, String message) {
    log(category, LogLevel.DEBUG, message);
  }

  public void debug(String category, String message, String exceptionClass)
      throws Exception {
    log(category, LogLevel.DEBUG, message, exceptionClass);
  }

  public void trace(String message) {
    trace(defaultCategory, message);
  }

  public void trace(String category, String message) {
    log(category, LogLevel.TRACE, message);
  }

  public void trace(String category, String message, String exceptionClass)
      throws Exception {
    log(category, LogLevel.TRACE, message, exceptionClass);
  }

  /**
   * Logs the given message using the category and level.
   *
   * @param category
   *          the category to use
   * @param level
   *          the log level
   * @param message
   *          the message to log
   */
  private void log(String category, LogLevel level, String message) {
    org.jboss.logging.Logger logger = org.jboss.logging.Logger
        .getLogger(category);
    level.log(logger, message);
  }

  /**
   * Logs the given message using the category, level and an exception of the
   * given class name. If the class does not exist in classpath, it will be
   * created (if possible) at runtime.
   *
   * @param category
   *          the category to use
   * @param level
   *          the log level
   * @param message
   *          the message to log
   * @param exceptionClass
   *          the exception cause
   */
  private void log(String category, LogLevel level, String message,
      String exceptionClass) throws Exception {
    Logger logger = Logger.getLogger(category);
    Throwable exception;
    try {
      Class<?> c = Class.forName(exceptionClass);
      // tries to create the exception using the message in constructor
      try {
        Constructor<?> constructor = c.getDeclaredConstructor(String.class);
        exception = (Throwable) constructor.newInstance(message);
      } catch (Exception e) {
        // use the default constructor
        exception = (Throwable) c.newInstance();
      }
    } catch (ClassNotFoundException e) {
      // tries to create the exception at runtime
      ClassPool classPool = ClassPool.getDefault();
      CtClass superClass = classPool.getCtClass(Exception.class
          .getCanonicalName());
      CtClass dynaClass = classPool.makeClass(exceptionClass, superClass);
      exception = (Exception) dynaClass.toClass().newInstance();
      dynaClass.detach();
    }
    level.log(logger, message, exception);
  }

}
