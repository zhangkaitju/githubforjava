package cn.edu.tju.entity;

import java.util.Date;
import java.util.List;

import cn.edu.tju.util.Dates;

public class Project extends GitHubEntity {
	private int id;
	private String name;
	private String description;
	private String language;
	private List<Language> languages;
	private List<Issue> issues;
	private List<Milestone> milestones;
	private List<Commit> commits;
	private List<Contributor> contributors;
	private User user;
	private String checkoutURL;
	private String sourceCodeURL;
	private Date createdAt;
	private Date lastPushedAt;
	private boolean isFork;
	private boolean hasDownloads;
	private boolean hasIssues;
	private boolean hasWiki;
	private int watchersCount;
	private int forks_count;
	private int issuesCount;
	
	public Project(User user, String name) {
		this.user = user;
		this.name = name;
		this.checkoutURL = "https://github.com/" + user.getLogin() + "/" + name + ".git";
		this.sourceCodeURL = "https://github.com/" + user.getLogin() + "/" + name;
	}
	public Project(){
		
	}
	public Project(String name, String description, String checkoutURL) {
		this.name = name;
		this.description = description;
		this.checkoutURL = checkoutURL;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getOwner() {
		return this.user;
	}
	public void setOwner(User owner) {
		this.user = owner;
	}
	public String getCheckoutURL() {
		return this.checkoutURL;
	}

	public void setCheckoutURL(String scmURL) {
		this.checkoutURL = scmURL;
	}

	/**
	 * Informs the source code URL of the project
	 * @return a String correspondent to the source code URL of the project in question
	 */
//	public String getSourceCodeURL() {
//		return this.sourceCodeURL;
//	}

	/**
	 * Sets the source code URL for the project
	 * @param sourceCodeURL sets the URL String of the project's source code
	 */
//	public void setSourceCodeURL(String sourceCodeURL) {
//		this.sourceCodeURL = sourceCodeURL;
//	}

	/**
	 * Informs whether a project allow downloads or not
	 * @return true if the project allows source code download. Returns false otherwise.
	 */
	public boolean hasDownloads() {
		return this.hasDownloads;
	}

	/**
	 * Sets if a project allows downloads or not
	 * @param hasDownloads a {@link boolean} for setting whether the project enables downloads or not
	 */
	public void setHasDownloads(boolean hasDownloads) {
		this.hasDownloads = hasDownloads;
	}

	/**
	 * @return true if the project has issues. Returns false otherwise.
	 */
	public boolean hasIssues() {
		return this.hasIssues;
	}

	/**
	 * @param hasIssues a boolean value for setting if the project has Issues or not
	 */
	public void setHasIssues(boolean hasIssues) {
		this.hasIssues = hasIssues;
	}

	/**
	 * Informs whether the project has its own Wiki or not.
	 * @return true if the project has a Wiki. Returns false otherwise.
	 */
	public boolean hasWiki() {
		return this.hasWiki;
	}

	/**
	 * Sets whether a project has its own Wiki or not.
	 * @param hasWiki a {@link boolean} for setting whether the project has a Wiki or not.
	 */
	public void setHasWiki(boolean hasWiki) {
		this.hasWiki = hasWiki;
	}

	/**
	 * Informs how many people are watching the project or have "starred" it
	 * @return an {@link integer} informing how many people are currently watching the project on its forge
	 */
	public int getWatchersCount() {
		return this.watchersCount;
	}
	public void setWatchersCount(int watchersCount) {
		this.watchersCount = watchersCount;
	}
	public int getForksCount() {
		return this.forks_count;
	}
	public void setForksCount(int forksCount) {
		this.forks_count = forksCount;
	}
	public int getIssuesCount() {
		return this.issuesCount;
	}
	public void setIssuesCount(int issuesCount) {
		this.issuesCount = issuesCount;
	}
	public boolean isFork() {
		return this.isFork;
	}
	public void setIsFork(boolean value) {
		this.isFork = value;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setCreatedAt(String createdAtParam) {
		Date createAtDate = new Dates("yyyy-MM-dd HH:mm:ss").format(createdAtParam);
		this.createdAt = createAtDate;
	}
	public Date getLastPushedAt() {
		return this.lastPushedAt;
	}

	public void setLastPushedAt(Date lastPushedAtParam) {
		this.lastPushedAt = lastPushedAtParam;
	}

	public void setLastPushedAt(String lastPushedAtParam){
		Date lastPushDate = new Dates("yyyy-MM-dd HH:mm:ss").format(lastPushedAtParam);
		this.lastPushedAt = lastPushDate;
	}
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	public List<Language> getLanguages() {
		return this.languages;
	}
	public void setLanguages(List<Language> langs) {
		this.languages = langs;
	}
	public List<Milestone> getMilestones() {
		return this.milestones;
	}

	public void setMilestones(List<Milestone> milestones) {
		this.milestones = milestones;
	}
	public List<Issue> getIssues() {
		return this.issues;
	}
	
	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}
	public List<Commit> getCommits() {
		return this.commits;
	}
	
	public void setCommits(List<Commit> commits) {
		this.commits = commits;
	}
	
	public List<Contributor> getContributors() {
		return this.contributors;
	}
	
	public void setContributors(List<Contributor> contributors) {
		this.contributors = contributors;
	}
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public boolean isActive() {
		if (commits == null && contributors == null) {
			return false;
		} else {
			return ((commits.size() > 1) && (contributors.size() > 2));			
		}
	}
	public boolean isMature() {
		return ((watchersCount > 3) && (forks_count > 1) && (commits.size() > 100) && (issues.size() > 5));
	}
	
	public String getURL() {
		return String.format("https://api.github.com/repos/%s/%s", this.getUser().getLogin(), this.getName());
	}
	public boolean equals(Project project){
		if(this.id == project.getId()){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	public String toString() {
		return String.format("Project(%s, %s)", this.name, this.sourceCodeURL);
	}
}