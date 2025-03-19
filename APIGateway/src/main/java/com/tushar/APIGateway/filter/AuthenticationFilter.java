package com.tushar.APIGateway.filter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.tushar.APIGateway.util.JwtUtil;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config>
{
	public static class Config
	{
		
	}
	@Autowired
	private RouteValidator validator;
	@Autowired
	private JwtUtil jwtutil;
	

	public AuthenticationFilter() {
		super(Config.class);
		// TODO Auto-generated constructor stub
	}


	@Override
	public GatewayFilter apply(Config config) {
		// TODO Auto-generated method stub

		 return ((exchange, chain) -> {
	            if (validator.isSecured.test(exchange.getRequest())) {
	                //header contains token or not
	                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
	                    throw new RuntimeException("missing authorization header");
	                }

	                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
	                if (authHeader != null && authHeader.startsWith("Bearer ")) {
	                    authHeader = authHeader.substring(7);
	                }
	                try {
//	                    //REST call to AUTH service
//	                    template.getForObject("http://IDENTITY-SERVICE//validate?token" + authHeader, String.class);
	                    jwtutil.validateToken(authHeader);

	                } catch (Exception e) {
	                    System.out.println("invalid access...!");
	                    throw new RuntimeException("un authorized access to application");
	                }
	            }
	            return chain.filter(exchange);
	        });
	    }
	}
