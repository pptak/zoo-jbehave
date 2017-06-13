package net.zoo;

import static java.util.Arrays.asList;

import org.jbehave.core.Embeddable;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import net.zoo.gorilla.MoreBananasStory;

@RunWith(AnnotatedEmbedderRunner.class)
@Configure(storyReporterBuilder = ZOOStoryReporterBuilder.class)
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, 
	ignoreFailureInStories = true, ignoreFailureInView = true, metaFilters = "-skip")
@UsingSteps(instances = { MoreBananasStory.class })
public class ZOOTestRunner implements Embeddable {

	private Embedder embedder;
	
	@Test
	@Override
	public void run() throws Throwable {
		embedder.runStoriesAsPaths(new StoryFinder().findPaths(this.getClass().getClassLoader().getResource(""),
                asList("**/*.story"), asList("")));
		
	}
	@Override
	public void useEmbedder(Embedder embedder) {
		this.embedder = embedder;
	}

}
