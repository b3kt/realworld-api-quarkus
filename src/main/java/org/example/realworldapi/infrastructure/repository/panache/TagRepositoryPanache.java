package org.example.realworldapi.infrastructure.repository.panache;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.example.realworldapi.domain.model.entity.Tag;
import org.example.realworldapi.domain.model.repository.TagRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TagRepositoryPanache implements PanacheRepository<Tag>, TagRepository {

  @Override
  public Optional<Tag> findByName(String tagName) {
    return find("upper(name)", tagName.toUpperCase().trim()).firstResultOptional();
  }

  @Override
  public Tag create(Tag tag) {
    persistAndFlush(tag);
    return tag;
  }

  @Override
  public List<Tag> findAllTags() {
    return listAll();
  }
}
