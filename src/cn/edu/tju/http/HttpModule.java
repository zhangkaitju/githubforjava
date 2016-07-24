package cn.edu.tju.http;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

public class HttpModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Requests.class).in(Singleton.class);
		bind(String.class)
				.annotatedWith(Names.named("githubOauthToken"))
				.toInstance("access_token=adf6e7534a35b112ce695e1fa9fa4ff66fbdeade");
	}
}