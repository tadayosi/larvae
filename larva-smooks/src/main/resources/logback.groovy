appender("STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {  pattern = '%-5p %d{"HH:mm:ss,SSS"} [%C.%M:%L] %m%n' }
}

logger "larvae", DEBUG
logger "org.smooks", INFO

root WARN, ["STDOUT"]
