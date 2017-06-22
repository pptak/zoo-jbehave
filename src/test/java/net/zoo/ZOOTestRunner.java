package net.zoo;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

import java.util.List;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import net.zoo.gorilla.GorillaMoreBananasSteps;
import net.zoo.staff.DoLoginSteps;
import net.zoo.staff.StaffMustLoginToOpenCageSteps;

@RunWith(AnnotatedEmbedderRunner.class)
@Configure(storyReporterBuilder = ZOOStoryReporterBuilder.class)
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = false, ignoreFailureInView = false, metaFilters = "-skip")
@UsingSteps(instances = { GorillaMoreBananasSteps.class, StaffMustLoginToOpenCageSteps.class,
		DoLoginSteps.class,  })
public class ZOOTestRunner extends InjectableEmbedder {

	@Test
	@Override
	public void run() throws Throwable {
		List<String> storyPaths = new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/*.story", "");
		injectedEmbedder().runStoriesAsPaths(storyPaths);
	}

}
