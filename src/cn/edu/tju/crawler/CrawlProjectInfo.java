package cn.edu.tju.crawler;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHPullRequest;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHRepository.Contributor;
import org.kohsuke.github.GitHub;

public class CrawlProjectInfo {

	//oauth认证token
	public static final String oauthAccessToken = "adf6e7534a35b112ce695e1fa9fa4ff66fbdeade";
	public static GitHub github;
	
	public CrawlProjectInfo(){
		try {
			github = GitHub.connectUsingOAuth(oauthAccessToken);
			System.out.println(github.getRateLimit());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 *  github三种查找方式
	 *@return Iterator<GHRepository>
	 *
	 */
	
	//查找github上所有的项目
	public Iterator<GHRepository> searchAllRepositories(){
		return github.listAllPublicRepositories().iterator();
	}
	//按star数查找github上的项目
	public Iterator<GHRepository> searchByStars(String star){
		return github.searchRepositories().stars(star).list().iterator();
	}
	//按repoName查找指定项目
	public GHRepository searchByRepoName(String repoName) throws IOException{
		 return github.getRepository(repoName);
	}
	
	/**
	 * 得到指定项目的元数据信息
	 * @param repo
	 * @return
	 */
	
	//得到项目所有者的名字
	public String getOwnerName(GHRepository repo){
		return repo.getOwnerName();
	}
	//得到指定项目的commit
	public Iterator<GHCommit> getCommit(GHRepository repo){
		return repo.listCommits().iterator();
	}
	//得到指定项目的contributor
	public List<Contributor> getContributors(GHRepository repo) throws IOException{
		return repo.listContributors().asList();
	}
	//得到指定项目的不同状态的PR
	public List<GHPullRequest> getPullRequest(GHRepository repo, GHIssueState state){
		return repo.listPullRequests(state).asList();
	}
	//得到指定项目的不同状态的Issue
	public List<GHIssue> getIssue(GHRepository repo, GHIssueState state){
		return repo.listIssues(state).asList();
	}
	public int getWatchers(GHRepository repo){
		return repo.getWatchers();
	}
	
	public static void main(String[] args) throws IOException {
		CrawlProjectInfo cpi = new CrawlProjectInfo();
		

		//查找github上star数大于50的项目
		Iterator<GHRepository> it = cpi.searchByStars(">50");
		while(it.hasNext()){
			String next = it.next().toString();
			
			String repoName = next.split(":")[1] + "/" + next.split(":")[2];
			GHRepository repo = cpi.searchByRepoName(repoName);
			
			int wathcers = cpi.getWatchers(repo);
			System.out.println("project name :" + repoName);
			System.out.println("number of watchers :" + wathcers);
//			Iterator<GHCommit> commitIterator = cpi.getCommit(repo);
//			while(commitIterator.hasNext()){
//				System.out.println(commitIterator.next().getAuthor());
//			}
//			System.out.println(repo.getOwnerName());
			break;
		}
	}

}
