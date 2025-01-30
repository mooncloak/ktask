//[ktask-core](../../../../index.md)/[com.mooncloak.kodetools.ktask](../../index.md)/[TaskEvent](../index.md)/[Action](index.md)

# Action

[common]\
@Serializable

enum [Action](index.md) : [Enum](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-enum/index.html)&lt;[TaskEvent.Action](index.md)&gt; 

Enum representing possible actions associated with a task.

Actions define the type of operation to be performed on a task.

## Entries

| | |
|---|---|
| [SCHEDULE](-s-c-h-e-d-u-l-e/index.md) | [common]<br>@SerialName(value = &quot;schedule&quot;)<br>[SCHEDULE](-s-c-h-e-d-u-l-e/index.md)<br>Represents the action of scheduling a task to be executed. |
| [REMOVE](-r-e-m-o-v-e/index.md) | [common]<br>@SerialName(value = &quot;remove&quot;)<br>[REMOVE](-r-e-m-o-v-e/index.md)<br>Represents the action of removing a task from a task queue or schedule. |
| [EXECUTE](-e-x-e-c-u-t-e/index.md) | [common]<br>@SerialName(value = &quot;execute&quot;)<br>[EXECUTE](-e-x-e-c-u-t-e/index.md)<br>Represents the action of immediately executing a task. |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](entries.md) | [common]<br>val [entries](entries.md): [EnumEntries](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.enums/-enum-entries/index.html)&lt;[TaskEvent.Action](index.md)&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [name](-e-x-e-c-u-t-e/index.md#-372974862%2FProperties%2F-1208774570) | [common]<br>val [name](-e-x-e-c-u-t-e/index.md#-372974862%2FProperties%2F-1208774570): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| [ordinal](-e-x-e-c-u-t-e/index.md#-739389684%2FProperties%2F-1208774570) | [common]<br>val [ordinal](-e-x-e-c-u-t-e/index.md#-739389684%2FProperties%2F-1208774570): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |

## Functions

| Name | Summary |
|---|---|
| [valueOf](value-of.md) | [common]<br>fun [valueOf](value-of.md)(value: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [TaskEvent.Action](index.md)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [common]<br>fun [values](values.md)(): [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[TaskEvent.Action](index.md)&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |
