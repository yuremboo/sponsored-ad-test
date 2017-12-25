package com.sponsored.ad.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "CAMPAIGN")
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "products")
@ToString(exclude = "products")
public class Campaign implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CAMPAIGN_PROJECT", joinColumns = @JoinColumn(name = "campaign_fk", foreignKey = @ForeignKey(name = "FK_PROJ_CAMP")), inverseJoinColumns = @JoinColumn(name = "project_fk", foreignKey = @ForeignKey(name = "FK_CAMP_PROJ")))
	private Set<Product> products;

	@Column(name = "date", nullable = false)
	private LocalDateTime startDate;

	@Column(name = "category")
	private String category;

	@Transient
	private Boolean active;

	@PostLoad
	public void postLoad() {
		LocalDateTime tenDaysAgo = LocalDateTime.now().minusDays(10);
		active = startDate.isAfter(tenDaysAgo);
	}
}
