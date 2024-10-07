package com.dev.fwk.common.exception;

public class ExceptionCode {

	public enum ClientError {
		
		BAD_REQUEST_EXCEPTION("BAD_REQUEST_EXCEPTION", "4001"),
		
		REST_READ_TIMEOUT_EXCEPTION("READ_TIMEOUT_EXCEPTION", "4201"),
		REST_CONNECTION_TIMEOUT_EXCEPTION("READ_TIMEOUT_EXCEPTION", "4202"),
		REST_UNKNOWN_EXCEPTION("RESTFULL_UNKNOWN_EXCEPTION", "4299");
		
		private final String info;
		private final String cd;
		
		ClientError(String info, String cd) {
			this.info = info;
			this.cd = cd;
		}

		public String getInfo() {
			return info;
		}

		public String getCd() {
			return cd;
		}
		
	}
}
