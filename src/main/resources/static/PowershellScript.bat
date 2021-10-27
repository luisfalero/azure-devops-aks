$setContent=@'

secrets:
  ConnectionString:
    UriCosmos: "$(URI_COSMOS)"
    KeyCosmos: "$(KEY_COSMOS)"
'@

$setContent | out-file -filepath set-file.yml
Get-Content -Path set-file.yml