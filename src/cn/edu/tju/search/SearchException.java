package cn.edu.tju.search;

import cn.edu.tju.entity.MyException;



/**
 * Thrown when something nasty happens
 * 
 */
public class SearchException extends MyException {
	private static final long serialVersionUID = 1L;

	public SearchException(Throwable e) {
		super(e);
	}
}