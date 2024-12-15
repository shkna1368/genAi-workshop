package com.shabab.aiproject.huggingface;

public class InferenceRequestToHuggingFace {
    private String inputs;
    private Options options;

    private Parameters parameters;

    public String getInputs() {
        return inputs;
    }

    public void setInputs(String inputs) {
        this.inputs = inputs;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public InferenceRequestToHuggingFace(String inputs) {
        this.inputs = inputs;
        this.options = new Options(false, true);
        this.parameters = new Parameters(0.9, 0.2,false,3000,6000,5000,8000,2000);
    }

}

record Options(Boolean use_cache, Boolean wait_for_model){}
record Parameters(Double top_p, Double temperature,Boolean return_full_text,int min_length,int max_length,int top_k,long max_new_tokens,int num_return_sequences){}




