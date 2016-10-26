import org.alti.steps.AdditionStepDef;
import org.alti.steps.GmailLoginStepsDef;
import org.jbehave.core.Embeddable;
import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.LoadFromURL;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.ParameterConverters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.StoryReporterBuilder.Format.*;

/**
 * Created by vdeshpande on 20-09-2016.
 */

@RunWith(AnnotatedEmbedderRunner.class)
@Configure(storyControls = JbehaveScenarios.MyStoryControls.class, storyLoader = JbehaveScenarios.MyStoryLoader.class, storyReporterBuilder = JbehaveScenarios.MyReportBuilder.class,
        parameterConverters = { JbehaveScenarios.MyDateConverter.class })
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = true, ignoreFailureInView = true,
         metaFilters = "-skip")
@UsingSteps(instances = { AdditionStepDef.class, GmailLoginStepsDef.class })
public class JbehaveScenarios extends InjectableEmbedder {

    @Test
    public void run() {
        try {
            URL storyURL = new URL("file://" + System.getProperty("user.dir")
                    + "/src/main/resources/features/");

        List<String> storyPaths = new StoryFinder().findPaths(storyURL, "*.story", "");
        injectedEmbedder().runStoriesAsPaths(storyPaths);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static class MyStoryControls extends StoryControls {
        public MyStoryControls() {
            doDryRun(false);
            doSkipScenariosAfterFailure(false);
        }
    }

    public static class MyStoryLoader extends LoadFromClasspath {
        public MyStoryLoader() {
            super(JbehaveScenarios.class.getClassLoader());
        }
    }

    public static class MyReportBuilder extends StoryReporterBuilder {
        public MyReportBuilder() {
            this.withFormats(CONSOLE, TXT, HTML, XML).withDefaultFormats();
        }
    }

    public static class MyRegexPrefixCapturingPatternParser extends RegexPrefixCapturingPatternParser {
        public MyRegexPrefixCapturingPatternParser() {
            super("%");
        }
    }

    public static class MyDateConverter extends ParameterConverters.DateConverter {
        public MyDateConverter() {
            super(new SimpleDateFormat("yyyy-MM-dd"));
        }
    }

}
