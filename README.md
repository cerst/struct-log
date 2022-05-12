# README

## Motivation
* all Logging MUST be structured
* creation of logs MUST be compile-time-safe (no loosing logs due to e.g. Jackson runtime errors)
* log creation MUST be independent of log shipping - even in the app (allows for other shipping variants such as back-pressure integrated in streams)
* except for standard members supplied to all logs, all its members SHOULD be evident at the call site
* log serialization SHOULD be pluggable


## Design
1) Interface with methods to create structured log
2) Interface for serializing structured logs
3) Interface for shipping serialized, structured logs

