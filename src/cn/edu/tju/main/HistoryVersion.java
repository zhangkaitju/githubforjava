package cn.edu.tju.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.kohsuke.github.GHAsset;
import org.kohsuke.github.GHEventInfo;
import org.kohsuke.github.GHRelease;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHRepository.Contributor;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.PagedIterable;

import cn.edu.tju.util.DBManager;

public class HistoryVersion {

	public static final String oauthAccessToken = "adf6e7534a35b112ce695e1fa9fa4ff66fbdeade";
	
	public static void main(String[] args) throws IOException {
		GitHub github = GitHub.connectUsingOAuth(oauthAccessToken);
		System.out.println(github.getRateLimit());
		
		GHRepository ghrepo = github.getRepository("twbs/bootstrap");
		System.out.println(ghrepo.getNetworkCount());
		System.out.println(ghrepo.getForks());

		PagedIterable<GHRelease> releases = ghrepo.listReleases();
		int id = 0;
		List<String> dataList = new ArrayList<String>();
		for(GHRelease release : releases){
			System.out.println(id+++" ");
		
			System.out.println(release.getName());
			//System.out.println(release.getTagName());
			System.out.println(release.getCreatedAt());
			System.out.println(release.getPublished_at());
			
			System.out.println(release.getBody());
			 List<GHAsset> assets = release.getAssets();
			 for(GHAsset ghassert : assets){
				 System.out.println(ghassert.getSize());
				 System.out.println(ghassert.getState());
				 System.out.println(ghassert.getName());
				 System.out.println(ghassert.getContentType());
			 }
		}
		
//		PagedIterable<Contributor> contributors = ghrepo.listContributors();
//		String sql = "insert into events values(?,?,?,?,?)";

	}
}
