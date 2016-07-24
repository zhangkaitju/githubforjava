package cn.edu.tju.entity;

import java.io.IOException;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHRepositorySearchBuilder;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.PagedSearchIterable;

public class Test {

	public static final String oauthAccessToken = "adf6e7534a35b112ce695e1fa9fa4ff66fbdeade";
	
	public static void main(String[] args) throws IOException {
		GitHub github = GitHub.connectUsingOAuth(oauthAccessToken);
		System.out.println(github.getRateLimit());
		
		GHRepositorySearchBuilder stars = github.searchRepositories().stars("5");
		PagedSearchIterable<GHRepository> it = stars.list();
		while(it.iterator().hasNext()){
			GHRepository ghrepo = it.iterator().next();
			System.out.println(ghrepo.getFullName());
	}
		 
//		List<GHEventInfo> events= github.getEvents();
//		Iterator<GHEventInfo> it = events.iterator();
//		while(it.hasNext()){
//			GHEventInfo event = it.next();
//			//System.out.println(event.getActorLogin());
//		}
	}

}
