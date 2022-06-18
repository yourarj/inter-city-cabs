/* (C)2022 */
package com.github.yourarj.intercitycabs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@ToString
public class User {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

private String userName;

protected User() {}

public User(final String userName) {
	this.userName = userName;
}
}
