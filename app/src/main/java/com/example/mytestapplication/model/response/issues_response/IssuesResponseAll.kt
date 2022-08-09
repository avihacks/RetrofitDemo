package com.example.mytestapplication.model.response.issues_response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class IssuesResponseAll(

/*
	@field:SerializedName("IssuesResponseAll")
	val issuesResponseAll: IssuesResponseAllItem = IssuesResponseAllItem()
*/
	@SerializedName("url")
@Expose
var url: String? = null,

@SerializedName("repository_url")
@Expose
var repositoryUrl: String? = null,

@SerializedName("labels_url")
@Expose
var labelsUrl: String? = null,

@SerializedName("comments_url")
@Expose
var commentsUrl: String? = null,

@SerializedName("events_url")
@Expose
var eventsUrl: String? = null,

@SerializedName("html_url")
@Expose
var htmlUrl: String? = null,

@SerializedName("id")
@Expose
var id: Int? = null,

@SerializedName("node_id")
@Expose
var nodeId: String? = null,

@SerializedName("number")
@Expose
var number: Int? = null,

@SerializedName("title")
@Expose
var title: String? = null,

@SerializedName("user")
@Expose
var user: User? = null,

@SerializedName("labels")
@Expose
var labels: List<LabelsItem>? = null,

@SerializedName("state")
@Expose
var state: String? = null,

@SerializedName("locked")
@Expose
var locked: Boolean? = null,

@SerializedName("assignee")
@Expose
var assignee: Any? = null,

@SerializedName("assignees")
@Expose
var assignees: List<Assignee>? = null,

@SerializedName("milestone")
@Expose
var milestone: Any? = null,

@SerializedName("comments")
@Expose
var comments: Int? = null,

@SerializedName("created_at")
@Expose
var createdAt: String? = null,

@SerializedName("updated_at")
@Expose
var updatedAt: String? = null,

@SerializedName("closed_at")
@Expose
var closedAt: Any? = null,

@SerializedName("author_association")
@Expose
var authorAssociation: String? = null,

@SerializedName("active_lock_reason")
@Expose
var activeLockReason: Any? = null,

@SerializedName("body")
@Expose
var body: String? = null,

@SerializedName("reactions")
@Expose
var reactions: Reactions? = null,

@SerializedName("timeline_url")
@Expose
var timelineUrl: String? = null,

@SerializedName("performed_via_github_app")
@Expose
var performedViaGithubApp: Any? = null,

@SerializedName("state_reason")
@Expose
var stateReason: Any? = null
)

data class IssuesResponseAllItem (
	@SerializedName("url")
	@Expose
	var url: String? = null,

	@SerializedName("repository_url")
	@Expose
	var repositoryUrl: String? = null,

	@SerializedName("labels_url")
	@Expose
	var labelsUrl: String? = null,

	@SerializedName("comments_url")
	@Expose
	var commentsUrl: String? = null,

	@SerializedName("events_url")
	@Expose
	var eventsUrl: String? = null,

	@SerializedName("html_url")
	@Expose
	var htmlUrl: String? = null,

	@SerializedName("id")
	@Expose
	var id: Int? = null,

	@SerializedName("node_id")
	@Expose
	var nodeId: String? = null,

	@SerializedName("number")
	@Expose
	var number: Int? = null,

	@SerializedName("title")
	@Expose
	var title: String? = null,

	@SerializedName("user")
	@Expose
	var user: User? = null,

	@SerializedName("labels")
	@Expose
	var labels: List<LabelsItem>? = null,

	@SerializedName("state")
	@Expose
	var state: String? = null,

	@SerializedName("locked")
	@Expose
	var locked: Boolean? = null,

	@SerializedName("assignee")
	@Expose
	var assignee: Any? = null,

	@SerializedName("assignees")
	@Expose
	var assignees: List<Assignee>? = null,

	@SerializedName("milestone")
	@Expose
	var milestone: Any? = null,

	@SerializedName("comments")
	@Expose
	var comments: Int? = null,

	@SerializedName("created_at")
	@Expose
	var createdAt: String? = null,

	@SerializedName("updated_at")
	@Expose
	var updatedAt: String? = null,

	@SerializedName("closed_at")
	@Expose
	var closedAt: Any? = null,

	@SerializedName("author_association")
	@Expose
	var authorAssociation: String? = null,

	@SerializedName("active_lock_reason")
	@Expose
	var activeLockReason: Any? = null,

	@SerializedName("body")
	@Expose
	var body: String? = null,

	@SerializedName("reactions")
	@Expose
	var reactions: Reactions? = null,

	@SerializedName("timeline_url")
	@Expose
	var timelineUrl: String? = null,

	@SerializedName("performed_via_github_app")
	@Expose
	var performedViaGithubApp: Any? = null,

	@SerializedName("state_reason")
	@Expose
	var stateReason: Any? = null
)
data class User(
	@SerializedName("login"               ) var login             : String?  = null,
	@SerializedName("id"                  ) var id                : Int?     = null,
	@SerializedName("node_id"             ) var nodeId            : String?  = null,
	@SerializedName("avatar_url"          ) var avatarUrl         : String?  = null,
	@SerializedName("gravatar_id"         ) var gravatarId        : String?  = null,
	@SerializedName("url"                 ) var url               : String?  = null,
	@SerializedName("html_url"            ) var htmlUrl           : String?  = null,
	@SerializedName("followers_url"       ) var followersUrl      : String?  = null,
	@SerializedName("following_url"       ) var followingUrl      : String?  = null,
	@SerializedName("gists_url"           ) var gistsUrl          : String?  = null,
	@SerializedName("starred_url"         ) var starredUrl        : String?  = null,
	@SerializedName("subscriptions_url"   ) var subscriptionsUrl  : String?  = null,
	@SerializedName("organizations_url"   ) var organizationsUrl  : String?  = null,
	@SerializedName("repos_url"           ) var reposUrl          : String?  = null,
	@SerializedName("events_url"          ) var eventsUrl         : String?  = null,
	@SerializedName("received_events_url" ) var receivedEventsUrl : String?  = null,
	@SerializedName("type"                ) var type              : String?  = null,
	@SerializedName("site_admin"          ) var siteAdmin         : Boolean? = null
)

data class Reactions(
	@SerializedName("url"         ) var url        : String? = null,
	@SerializedName("total_count" ) var totalCount : Int?    = null,
//	@SerializedName("+1"          ) var +1         : Int?    = null,
//	@SerializedName("-1"          ) var -1         : Int?    = null,
	@SerializedName("laugh"       ) var laugh      : Int?    = null,
	@SerializedName("hooray"      ) var hooray     : Int?    = null,
	@SerializedName("confused"    ) var confused   : Int?    = null,
	@SerializedName("heart"       ) var heart      : Int?    = null,
	@SerializedName("rocket"      ) var rocket     : Int?    = null,
	@SerializedName("eyes"        ) var eyes       : Int?    = null
)

data class Milestone(

	@field:SerializedName("creator")
	val creator: Creator? = null,

	@field:SerializedName("closed_at")
	val closedAt: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("closed_issues")
	val closedIssues: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("due_on")
	val dueOn: String? = null,

	@field:SerializedName("labels_url")
	val labelsUrl: String? = null,

	@field:SerializedName("number")
	val number: Int? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("html_url")
	val htmlUrl: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("state")
	val state: String? = null,

	@field:SerializedName("open_issues")
	val openIssues: Int? = null,

	@field:SerializedName("node_id")
	val nodeId: String? = null
)

/*data class IssuesResponseAllItem(
	@SerializedName("url"                      ) var url                   : String?           = null,
	@SerializedName("repository_url"           ) var repositoryUrl         : String?           = null,
	@SerializedName("labels_url"               ) var labelsUrl             : String?           = null,
	@SerializedName("comments_url"             ) var commentsUrl           : String?           = null,
	@SerializedName("events_url"               ) var eventsUrl             : String?           = null,
	@SerializedName("html_url"                 ) var htmlUrl               : String?           = null,
	@SerializedName("id"                       ) var id                    : Int?              = null,
	@SerializedName("node_id"                  ) var nodeId                : String?           = null,
	@SerializedName("number"                   ) var number                : Int?              = null,
	@SerializedName("title"                    ) var title                 : String?           = null,
	@SerializedName("user"                     ) var user                  : User?             = User(),
	@SerializedName("labels"                   ) var labels                : ArrayList<LabelsItem> = arrayListOf(),
	@SerializedName("state"                    ) var state                 : String?           = null,
	@SerializedName("locked"                   ) var locked                : Boolean?          = null,
	@SerializedName("assignee"                 ) var assignee              : String?           = null,
	@SerializedName("assignees"                ) var assignees             : ArrayList<String> = arrayListOf(),
	@SerializedName("milestone"                ) var milestone             : String?           = null,
	@SerializedName("comments"                 ) var comments              : Int?              = null,
	@SerializedName("created_at"               ) var createdAt             : String?           = null,
	@SerializedName("updated_at"               ) var updatedAt             : String?           = null,
	@SerializedName("closed_at"                ) var closedAt              : String?           = null,
	@SerializedName("author_association"       ) var authorAssociation     : String?           = null,
	@SerializedName("active_lock_reason"       ) var activeLockReason      : String?           = null,
	@SerializedName("body"                     ) var body                  : String?           = null,
	@SerializedName("reactions"                ) var reactions             : Reactions?        = Reactions(),
	@SerializedName("timeline_url"             ) var timelineUrl           : String?           = null,
	@SerializedName("performed_via_github_app" ) var performedViaGithubApp : String?           = null,
	@SerializedName("state_reason"             ) var stateReason           : String?           = null
)*/

data class Creator(

	@field:SerializedName("gists_url")
	val gistsUrl: String? = null,

	@field:SerializedName("repos_url")
	val reposUrl: String? = null,

	@field:SerializedName("following_url")
	val followingUrl: String? = null,

	@field:SerializedName("starred_url")
	val starredUrl: String? = null,

	@field:SerializedName("login")
	val login: String? = null,

	@field:SerializedName("followers_url")
	val followersUrl: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("subscriptions_url")
	val subscriptionsUrl: String? = null,

	@field:SerializedName("received_events_url")
	val receivedEventsUrl: String? = null,

	@field:SerializedName("avatar_url")
	val avatarUrl: String? = null,

	@field:SerializedName("events_url")
	val eventsUrl: String? = null,

	@field:SerializedName("html_url")
	val htmlUrl: String? = null,

	@field:SerializedName("site_admin")
	val siteAdmin: Boolean? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("gravatar_id")
	val gravatarId: String? = null,

	@field:SerializedName("node_id")
	val nodeId: String? = null,

	@field:SerializedName("organizations_url")
	val organizationsUrl: String? = null
)

data class LabelsItem(

	@SerializedName("id"          ) var id          : String?     = null,
	@SerializedName("node_id"     ) var nodeId      : String?  = null,
	@SerializedName("url"         ) var url         : String?  = null,
	@SerializedName("name"        ) var name        : String?  = null,
	@SerializedName("color"       ) var color       : String?  = null,
	@SerializedName("default"     ) var default     : Boolean? = null,
	@SerializedName("description" ) var description : String?  = null
)

data class PullRequest(

	@field:SerializedName("patch_url")
	val patchUrl: String? = null,

	@field:SerializedName("html_url")
	val htmlUrl: String? = null,

	@field:SerializedName("merged_at")
	val mergedAt: String? = null,

	@field:SerializedName("diff_url")
	val diffUrl: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class AssigneesItem(

	@field:SerializedName("gists_url")
	val gistsUrl: String? = null,

	@field:SerializedName("repos_url")
	val reposUrl: String? = null,

	@field:SerializedName("following_url")
	val followingUrl: String? = null,

	@field:SerializedName("starred_url")
	val starredUrl: String? = null,

	@field:SerializedName("login")
	val login: String? = null,

	@field:SerializedName("followers_url")
	val followersUrl: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("subscriptions_url")
	val subscriptionsUrl: String? = null,

	@field:SerializedName("received_events_url")
	val receivedEventsUrl: String? = null,

	@field:SerializedName("avatar_url")
	val avatarUrl: String? = null,

	@field:SerializedName("events_url")
	val eventsUrl: String? = null,

	@field:SerializedName("html_url")
	val htmlUrl: String? = null,

	@field:SerializedName("site_admin")
	val siteAdmin: Boolean? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("gravatar_id")
	val gravatarId: String? = null,

	@field:SerializedName("node_id")
	val nodeId: String? = null,

	@field:SerializedName("organizations_url")
	val organizationsUrl: String? = null
)

data class Assignee(

	@field:SerializedName("gists_url")
	val gistsUrl: String? = null,

	@field:SerializedName("repos_url")
	val reposUrl: String? = null,

	@field:SerializedName("following_url")
	val followingUrl: String? = null,

	@field:SerializedName("starred_url")
	val starredUrl: String? = null,

	@field:SerializedName("login")
	val login: String? = null,

	@field:SerializedName("followers_url")
	val followersUrl: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("subscriptions_url")
	val subscriptionsUrl: String? = null,

	@field:SerializedName("received_events_url")
	val receivedEventsUrl: String? = null,

	@field:SerializedName("avatar_url")
	val avatarUrl: String? = null,

	@field:SerializedName("events_url")
	val eventsUrl: String? = null,

	@field:SerializedName("html_url")
	val htmlUrl: String? = null,

	@field:SerializedName("site_admin")
	val siteAdmin: Boolean? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("gravatar_id")
	val gravatarId: String? = null,

	@field:SerializedName("node_id")
	val nodeId: String? = null,

	@field:SerializedName("organizations_url")
	val organizationsUrl: String? = null
)
