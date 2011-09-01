package org.atatec.jboss.logger;

import org.jboss.logging.Logger;

public enum LogLevel {

  TRACE {
    @Override
    public void log(Logger logger, Object message) {
      logger.trace(message);
    }

    @Override
    public void log(Logger logger, Object message, Throwable cause) {
      logger.trace(message, cause);
    }
  },
  DEBUG {
    @Override
    public void log(Logger logger, Object message) {
      logger.debug(message);
    }

    @Override
    public void log(Logger logger, Object message, Throwable cause) {
      logger.debug(message, cause);
    }
  },
  INFO {
    @Override
    public void log(Logger logger, Object message) {
      logger.info(message);
    }

    @Override
    public void log(Logger logger, Object message, Throwable cause) {
      logger.info(message, cause);
    }
  },
  WARN {
    @Override
    public void log(Logger logger, Object message) {
      logger.warn(message);
    }

    @Override
    public void log(Logger logger, Object message, Throwable cause) {
      logger.warn(message, cause);
    }
  },
  ERROR {
    @Override
    public void log(Logger logger, Object message) {
      logger.error(message);
    }

    @Override
    public void log(Logger logger, Object message, Throwable cause) {
      logger.error(message, cause);
    }
  },
  FATAL {
    @Override
    public void log(Logger logger, Object message) {
      logger.fatal(message);
    }

    @Override
    public void log(Logger logger, Object message, Throwable cause) {
      logger.fatal(message, cause);
    }
  };

  public abstract void log(Logger logger, Object message);

  public abstract void log(Logger logger, Object message, Throwable cause);

}
