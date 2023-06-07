package com.RI._AdminModule.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="USER_ROLE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer role_id;
		
		@Column(name="ROLE")
		private String role;
		
		public Role(String role) {
			this.role=role;
		}
		
}
