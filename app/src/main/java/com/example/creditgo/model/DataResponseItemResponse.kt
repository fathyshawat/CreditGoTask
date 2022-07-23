package com.example.creditgo.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.creditgo.utils.Constants
import com.google.gson.annotations.SerializedName


data class Owner(

    @field:SerializedName("gists_url")
    var gistsUrlOwner: String? = null,

    @field:SerializedName("repos_url")
    var reposUrlOwner: String? = null,

    @field:SerializedName("following_url")
    var followingUrlOwner: String? = null,

    @field:SerializedName("starred_url")
    var starredUrlOwner: String? = null,

    @field:SerializedName("login")
    var loginOwner: String? = null,

    @field:SerializedName("followers_url")
    var followersUrlOwner: String? = null,

    @field:SerializedName("type")
    var typeOwner: String? = null,

    @field:SerializedName("url")
    var urlOwner: String? = null,

    @field:SerializedName("subscriptions_url")
    var subscriptionsUrlOwner: String? = null,

    @field:SerializedName("received_events_url")
    var receivedEventsUrlOwner: String? = null,

    @field:SerializedName("avatar_url")
    var avatarUrlOwner: String? = null,

    @field:SerializedName("events_url")
    var eventsUrlOwner: String? = null,

    @field:SerializedName("html_url")
    var htmlUrlOwner: String? = null,

    @field:SerializedName("site_admin")
    var siteAdminOwner: Boolean? = null,

    @field:SerializedName("id")
    var idOwner: Int? = null,

    @field:SerializedName("gravatar_id")
    var gravatarIdOwner: String? = null,

    @field:SerializedName("node_id")
    var nodeIdOwner: String? = null,

    @field:SerializedName("organizations_url")
    var organizationsUrlOwner: String? = null
)

@Entity(tableName = Constants.USERS_TABLE)
data class DataResponseItem(

    @field:SerializedName("allow_forking")
    var allowForking: Boolean? = null,

    @field:SerializedName("stargazers_count")
    var stargazersCount: Int? = null,

    @field:SerializedName("is_template")
    var isTemplate: Boolean? = null,

    @field:SerializedName("pushed_at")
    var pushedAt: String? = null,

    @field:SerializedName("subscription_url")
    var subscriptionUrl: String? = null,

    @field:SerializedName("language")
    var language: String? = null,

    @field:SerializedName("branches_url")
    var branchesUrl: String? = null,

    @field:SerializedName("issue_comment_url")
    var issueCommentUrl: String? = null,

    @field:SerializedName("labels_url")
    var labelsUrl: String? = null,

    @field:SerializedName("subscribers_url")
    var subscribersUrl: String? = null,

    @field:SerializedName("releases_url")
    var releasesUrl: String? = null,

    @field:SerializedName("svn_url")
    var svnUrl: String? = null,

    @PrimaryKey
    @field:SerializedName("id")
    var id: Int? = null,

    @field:SerializedName("forks")
    var forks: Int? = null,

    @field:SerializedName("archive_url")
    var archiveUrl: String? = null,

    @field:SerializedName("git_refs_url")
    var gitRefsUrl: String? = null,

    @field:SerializedName("forks_url")
    var forksUrl: String? = null,

    @field:SerializedName("visibility")
    var visibility: String? = null,

    @field:SerializedName("statuses_url")
    var statusesUrl: String? = null,

    @field:SerializedName("ssh_url")
    var sshUrl: String? = null,

    @field:SerializedName("full_name")
    var fullName: String? = null,

    @field:SerializedName("size")
    var size: Int? = null,

    @field:SerializedName("languages_url")
    var languagesUrl: String? = null,

    @field:SerializedName("html_url")
    var htmlUrl: String? = null,

    @field:SerializedName("collaborators_url")
    var collaboratorsUrl: String? = null,

    @field:SerializedName("clone_url")
    var cloneUrl: String? = null,

    @field:SerializedName("name")
    var name: String? = null,

    @field:SerializedName("pulls_url")
    var pullsUrl: String? = null,

    @field:SerializedName("default_branch")
    var defaultBranch: String? = null,

    @field:SerializedName("hooks_url")
    var hooksUrl: String? = null,

    @field:SerializedName("trees_url")
    var treesUrl: String? = null,

    @field:SerializedName("tags_url")
    var tagsUrl: String? = null,

    @field:SerializedName("private")
    var jsonMemberPrivate: Boolean? = null,

    @field:SerializedName("contributors_url")
    var contributorsUrl: String? = null,

    @field:SerializedName("has_downloads")
    var hasDownloads: Boolean? = null,

    @field:SerializedName("notifications_url")
    var notificationsUrl: String? = null,

    @field:SerializedName("open_issues_count")
    var openIssuesCount: Int? = null,

    @field:SerializedName("description")
    var description: String? = null,

    @field:SerializedName("created_at")
    var createdAt: String? = null,

    @field:SerializedName("watchers")
    var watchers: Int? = null,

    @field:SerializedName("keys_url")
    var keysUrl: String? = null,

    @field:SerializedName("deployments_url")
    var deploymentsUrl: String? = null,

    @field:SerializedName("has_projects")
    var hasProjects: Boolean? = null,

    @field:SerializedName("archived")
    var archived: Boolean? = null,

    @field:SerializedName("has_wiki")
    var hasWiki: Boolean? = null,

    @field:SerializedName("updated_at")
    var updatedAt: String? = null,

    @field:SerializedName("comments_url")
    var commentsUrl: String? = null,

    @field:SerializedName("stargazers_url")
    var stargazersUrl: String? = null,

    @field:SerializedName("disabled")
    var disabled: Boolean? = null,

    @field:SerializedName("git_url")
    var gitUrl: String? = null,

    @field:SerializedName("has_pages")
    var hasPages: Boolean? = null,

    @Embedded
    @field:SerializedName("owner")
    var owner: Owner? = null,

    @field:SerializedName("commits_url")
    var commitsUrl: String? = null,

    @field:SerializedName("compare_url")
    var compareUrl: String? = null,

    @field:SerializedName("git_commits_url")
    var gitCommitsUrl: String? = null,


    @field:SerializedName("blobs_url")
    var blobsUrl: String? = null,

    @field:SerializedName("git_tags_url")
    var gitTagsUrl: String? = null,

    @field:SerializedName("merges_url")
    var mergesUrl: String? = null,

    @field:SerializedName("downloads_url")
    var downloadsUrl: String? = null,

    @field:SerializedName("has_issues")
    var hasIssues: Boolean? = null,

    @field:SerializedName("web_commit_signoff_required")
    var webCommitSignoffRequired: Boolean? = null,

    @field:SerializedName("url")
    var url: String? = null,

    @field:SerializedName("contents_url")
    var contentsUrl: String? = null,

    @field:SerializedName("mirror_url")
    var mirrorUrl: String? = null,

    @field:SerializedName("milestones_url")
    var milestonesUrl: String? = null,

    @field:SerializedName("teams_url")
    var teamsUrl: String? = null,

    @field:SerializedName("fork")
    var fork: Boolean? = null,

    @field:SerializedName("issues_url")
    var issuesUrl: String? = null,

    @field:SerializedName("events_url")
    var eventsUrl: String? = null,

    @field:SerializedName("issue_events_url")
    var issueEventsUrl: String? = null,

    @field:SerializedName("assignees_url")
    var assigneesUrl: String? = null,

    @field:SerializedName("open_issues")
    var openIssues: Int? = null,

    @field:SerializedName("watchers_count")
    var watchersCount: Int? = null,

    @field:SerializedName("node_id")
    var nodeId: String? = null,

    @field:SerializedName("homepage")
    var homepage: String? = null,

    @field:SerializedName("forks_count")
    var forksCount: Int? = null
)
