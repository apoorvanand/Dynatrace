package com.neotys.dynatrace.sanityCheck;

import com.neotys.action.argument.ArgumentValidator;
import com.neotys.action.argument.Option;
import com.neotys.extensions.action.ActionParameter;

import static com.neotys.action.argument.DefaultArgumentValidator.ALWAYS_VALID;
import static com.neotys.action.argument.DefaultArgumentValidator.NON_EMPTY;
import static com.neotys.action.argument.Option.AppearsByDefault.False;
import static com.neotys.action.argument.Option.AppearsByDefault.True;
import static com.neotys.action.argument.Option.OptionalRequired.Optional;
import static com.neotys.action.argument.Option.OptionalRequired.Required;
import static com.neotys.extensions.action.ActionParameter.Type.TEXT;

enum DynatraceSanityCheckOption implements Option {
    DynatraceId("dynatraceId", Required, True, TEXT,
            "Dynatrace ID",
            "Dynatrace ID (section of your Dynatrace saas url).",
            NON_EMPTY),

    DynatraceApiKey("dynatraceApiKey", Required, True, TEXT,
            "Dynatrace API key.",
            "Dynatrace API key",
            NON_EMPTY),

    DynatraceTags("tags", Optional, True, TEXT,
            "tag1,tag2",
            "Dynatrace tags. Links the NeoLoad computed data to Dynatrace tags (format: tag1,tag2).",
            ALWAYS_VALID),
    DynatraceApplicationName("DynatraceApplicationName", Optional, True, TEXT,
            "easytravel",
            "Dynatrace Application Name. The sanitycheck will be based on the smartscape of the application.",
            ALWAYS_VALID),
    DynatraceManagedHostname("dynatraceManagedHostname", Optional, False, TEXT,
            "",
            "Hostname of your managed Dynatrace environment.",
            ALWAYS_VALID),


    NeoLoadProxy("proxyName", Optional, False, TEXT,
            "",
            "The NeoLoad proxy name to access Dynatrace.",
            ALWAYS_VALID),

    TraceMode("traceMode", Optional, False, TEXT,
            "",
            "",
            ALWAYS_VALID),

    OutputJSONReferenceFile("outPutReferenceFile", Optional, True, TEXT,
            "/home/hrexed/dynatrace_smarscape.json",
                    "json file containing the last reference of the architecture.\n The action will fail if the architecutre has less services, processes, less CPU, memory..etc",
            NON_EMPTY);

    private final String name;
    private final Option.OptionalRequired optionalRequired;
    private final Option.AppearsByDefault appearsByDefault;
    private final ActionParameter.Type type;
    private final String defaultValue;
    private final String description;
    private final ArgumentValidator argumentValidator;
    DynatraceSanityCheckOption(final String name, final Option.OptionalRequired optionalRequired,
                              final Option.AppearsByDefault appearsByDefault,
                              final ActionParameter.Type type, final String defaultValue, final String description,
                              final ArgumentValidator argumentValidator) {
        this.name = name;
        this.optionalRequired = optionalRequired;
        this.appearsByDefault = appearsByDefault;
        this.type = type;
        this.defaultValue = defaultValue;
        this.description = description;
        this.argumentValidator = argumentValidator;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Option.OptionalRequired getOptionalRequired() {
        return optionalRequired;
    }

    @Override
    public Option.AppearsByDefault getAppearsByDefault() {
        return appearsByDefault;
    }

    @Override
    public ActionParameter.Type getType() {
        return type;
    }

    @Override
    public String getDefaultValue() {
        return defaultValue;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public ArgumentValidator getArgumentValidator() {
        return argumentValidator;
    }
}
