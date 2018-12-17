package com.dms.caixa.event;

import javax.servlet.http.HttpServletResponse;

import com.dms.event.ResourceCreatedEvent;

/**
 * Captura eventos
 * 
 * @author Diorgenes Morais
 * @since 1.0.2
 *
 */
public class ResourceCreatedEventImpl extends ResourceCreatedEvent<Integer> {

	private static final long serialVersionUID = 7661492078946809889L;

	public ResourceCreatedEventImpl(Object source, HttpServletResponse response, Integer id) {
		super(source, response, id);
	}

}
