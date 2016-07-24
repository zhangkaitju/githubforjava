package cn.edu.tju.main;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.kohsuke.github.GHEventInfo;
import org.kohsuke.github.GHHook;
import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHMilestone;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHRepository.Contributor;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.PagedIterable;

import cn.edu.tju.util.DBManager;

public class Milestones {

	public static final String oauthAccessToken = "adf6e7534a35b112ce695e1fa9fa4ff66fbdeade";
	
	public static void main(String[] args) throws IOException {
		GitHub github = GitHub.connectUsingOAuth(oauthAccessToken);
		System.out.println(github.getRateLimit());
		
		GHRepository ghrepo = github.getRepository("twbs/bootstrap");
		//PagedIterable<Contributor> contributors = ghrepo.listContributors();
		PagedIterable<GHEventInfo> eventinfos = ghrepo.listEvents();
		
		 PagedIterable<GHMilestone> milestones = ghrepo.listMilestones(GHIssueState.CLOSED);
		int id = 0;
		for(GHMilestone milestone : milestones){
			System.out.println(id++);
			System.out.println(milestone.getTitle());
		}
	}
}
