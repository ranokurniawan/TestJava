package id.co.rano.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConsoleService {
	@Value("${ui.input.teks:unknown}")
	protected String uiInputTeks;
	
	public String getUiInputTeks() {
		return getUiInputTeks(uiInputTeks);
	}

	public String getUiInputTeks(String uiInputTeks) {
        return uiInputTeks;
    }
	
	@Value("${ui.count.teks:unknown}")
	protected String uiCountTeks;
	
	public String getUiCountTeks() {
		return getUiCountTeks(uiCountTeks);
	}

	public String getUiCountTeks(String uiCountTeks) {
        return uiCountTeks;
    }
	
	@Value("${ui.count.display.string:unknown}")
	protected String uiCountDisplayString;
	
	public String getUiCountDisplayString() {
		return getUiCountDisplayString(uiCountDisplayString);
	}

	public String getUiCountDisplayString(String uiCountDisplayString) {
        return uiCountDisplayString;
    }
	
	@Value("${ui.once.string.display:unknown}")
	protected String uiOnceStringDisplay;
	
	public String getUiOnceStringDisplay() {
		return getUiOnceStringDisplay(uiOnceStringDisplay);
	}

	public String getUiOnceStringDisplay(String uiOnceStringDisplay) {
        return uiOnceStringDisplay;
    }
	
	@Value("${ui.count.string.lot:unknown}")
	protected String uiCountStringLot;
	
	public String getUiCountStringLot() {
		return getUiCountStringLot(uiCountStringLot);
	}

	public String getUiCountStringLot(String uiCountStringLot) {
        return uiCountStringLot;
    }
	
	@Value("${ui.count.string.less:unknown}")
	protected String uiCountStringLess;
	
	public String getUiCountStringLess() {
		return getUiCountStringLess(uiCountStringLess);
	}

	public String getUiCountStringLess(String uiCountStringLess) {
        return uiCountStringLess;
    }
	
	@Value("${ui.end.char:unknown}")
	protected String uiEndChar;
	
	public String getUiEndChar() {
		return getUiEndChar(uiEndChar);
	}

	public String getUiEndChar(String uiEndChar) {
        return uiEndChar;
    }
	
	@Value("${ui.count.string.and:unknown}")
	protected String uiCountStringAnd;
	
	public String getUiCountStringAnd() {
		return getUiCountStringAnd(uiCountStringAnd);
	}

	public String getUiCountStringAnd(String uiCountStringAnd) {
        return uiCountStringAnd;
    }
}
