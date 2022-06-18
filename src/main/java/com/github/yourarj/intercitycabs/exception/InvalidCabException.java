/* (C)2022 */
package com.github.yourarj.intercitycabs.exception;

public class InvalidCabException extends Exception {
public InvalidCabException(final String message) {
	super(message);
}

public InvalidCabException(final long cabId) {
	this(String.format("Specified cab `%d` does not exist", cabId));
}
}
