package device.itself.test;

import java.util.ArrayList;
import java.util.Map;

import org.eclipse.egit.github.core.Gist;
import org.eclipse.egit.github.core.GistFile;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.sf.json.JSONObject;
import device.itself.util.RestClient;


public class JSONTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test="[{        'url': 'https://api.github.com/gists/13bc9129a47d6f69def8',        'forks_url': 'https://api.github.com/gists/13bc9129a47d6f69def8/forks',        'commits_url': 'https://api.github.com/gists/13bc9129a47d6f69def8/commits',        'id': '13bc9129a47d6f69def8',        'git_pull_url': 'https://gist.github.com/13bc9129a47d6f69def8.git',        'git_push_url': 'https://gist.github.com/13bc9129a47d6f69def8.git',        'html_url': 'https://gist.github.com/13bc9129a47d6f69def8',        'files': {            'hello.js': {                'filename': 'hello.js',                'type': 'application/javascript',                'language': 'JavaScript',                'raw_url': 'https://gist.githubusercontent.com/innamgo/13bc9129a47d6f69def8/raw/61a483392c3ddfb751cce464ec2de0242e274a8b/hello.js',                'size': 40            }        },        'public': true,        'created_at': '2015-06-04T07:48:22Z',        'updated_at': '2015-06-04T07:48:23Z',        'description': 'test',        'comments': 0,        'user': null,        'comments_url': 'https://api.github.com/gists/13bc9129a47d6f69def8/comments',        'owner': {            'login': 'innamgo',            'id': 2527128,            'avatar_url': 'https://avatars.githubusercontent.com/u/2527128?v=3',            'gravatar_id': '',            'url': 'https://api.github.com/users/innamgo',            'html_url': 'https://github.com/innamgo',            'followers_url': 'https://api.github.com/users/innamgo/followers',            'following_url': 'https://api.github.com/users/innamgo/following{/other_user}',            'gists_url': 'https://api.github.com/users/innamgo/gists{/gist_id}',            'starred_url': 'https://api.github.com/users/innamgo/starred{/owner}{/repo}',            'subscriptions_url': 'https://api.github.com/users/innamgo/subscriptions',            'organizations_url': 'https://api.github.com/users/innamgo/orgs',            'repos_url': 'https://api.github.com/users/innamgo/repos',            'events_url': 'https://api.github.com/users/innamgo/events{/privacy}',            'received_events_url': 'https://api.github.com/users/innamgo/received_events',            'type': 'User',            'site_admin': false        }    }]";
		String result=RestClient.getForString("https://api.github.com/users/innamgo/gists");
		Gson gson=new Gson();
		/*
		JsonParser parser = new JsonParser();
	    JsonArray array = parser.parse(test).getAsJsonArray();
	    
	    System.out.println("array:"+array);
	    */
		System.out.println("result:"+result.toString());
		Gist[] gist=gson.fromJson(result.toString(), Gist[].class);
		Map<String, GistFile> files=gist[0].getFiles();
		GistFile gistFile=null;
		for(int fileCount=0; fileCount < files.size(); fileCount++)
		{
			gistFile=files.get("hello.js");
			System.out.println("search:");
		}
		System.out.println("raw_url:"+gistFile.getRawUrl());
		

		
		
	}
	

}
