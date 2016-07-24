package cn.edu.tju.main;

import java.io.IOException;

import org.kohsuke.github.GHEventInfo;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHRepository.Contributor;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.PagedIterable;

import cn.edu.tju.util.DBManager;

public class ContributorEvents {

	public static final String oauthAccessToken = "adf6e7534a35b112ce695e1fa9fa4ff66fbdeade";
	
	public static void main(String[] args) throws IOException {
		GitHub github = GitHub.connectUsingOAuth(oauthAccessToken);
		System.out.println(github.getRateLimit());
		
		GHRepository ghrepo = github.getRepository("twbs/bootstrap");
		PagedIterable<Contributor> contributors = ghrepo.listContributors();
		String sql = "insert into events values(?,?,?,?,?)";
			for(Contributor con : contributors.asList()){
				System.out.println(con.getLogin());
				PagedIterable<GHEventInfo> enents = con.listEvents();
				int id = 0;
				try{
					for(GHEventInfo ghei :enents){
						System.out.print(id+++" ");
						System.out.println(ghei.getRepository().getFullName()+"--->"+ghei.getType()+"+++"+ghei.getCreatedAt());
					}
				}catch(Exception e){
					System.out.println(e);
					continue;
				}  
			}
	}
}
