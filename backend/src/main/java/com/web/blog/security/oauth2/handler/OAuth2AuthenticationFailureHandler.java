package com.web.blog.security.oauth2.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.blog.security.oauth2.dao.HttpCookieOAuth2AuthorizationRequestDao;
import com.web.blog.utils.CookieUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import static com.web.blog.security.oauth2.dao.HttpCookieOAuth2AuthorizationRequestDao.REDIRECT_URI_PARAM_COOKIE_NAME;

@Component
public class OAuth2AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    HttpCookieOAuth2AuthorizationRequestDao httpCookieOAuth2AuthorizationRequestDao;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // 에러가 발생하면 user는 client로 redirect되며, 에러 메세지는 Query String으로 전달
        String targetUrl = CookieUtils.getCookie(request, REDIRECT_URI_PARAM_COOKIE_NAME)
                                        .map(Cookie::getValue)
                                        .orElse(("/"));

        targetUrl = UriComponentsBuilder.fromUriString(targetUrl)
                                        .queryParam("error", exception.getLocalizedMessage())
                                        .build().toUriString();

        httpCookieOAuth2AuthorizationRequestDao.removeAuthorizationRequestCookies(request, response);

        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
}
