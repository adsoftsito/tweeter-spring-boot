package com.adsoft.spring.security.postgresql.SpringBootSecurityPostgresqlApplication.payload.request;

import jakarta.validation.constraints.NotBlank;

public class TweetReactionRequest {
  private Long tweetId;
  public Long getTweetId() {
    return tweetId;
}

  public void setTweetId(Long tweetId) {
    this.tweetId = tweetId;
  }

  private Long reactionId;

  public Long getReactionId() {
    return reactionId;
  }

  public void setReactionId(Long reactionId) {
    this.reactionId = reactionId;
  }


}