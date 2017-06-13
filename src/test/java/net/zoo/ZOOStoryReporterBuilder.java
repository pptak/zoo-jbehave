package net.zoo;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;

import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.StoryReporterBuilder;

public class ZOOStoryReporterBuilder extends StoryReporterBuilder {

	public ZOOStoryReporterBuilder() {
		withCodeLocation(codeLocationFromClass(ZOOStoryReporterBuilder.class));
		withDefaultFormats();
		withFormats(HTML, CONSOLE);
		withFailureTrace(true);
		withPathResolver(new FilePrintStreamFactory.ResolveToSimpleName());
	}

}
